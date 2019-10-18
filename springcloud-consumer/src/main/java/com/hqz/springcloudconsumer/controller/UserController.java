package com.hqz.springcloudconsumer.controller;

import com.hqz.springcloudconsumer.feignclient.UserFeignClient;
import com.hqz.springcloudconsumer.entity.Integral;
import com.hqz.springcloudconsumer.service.IntegralService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.util.StringUtils;

@RestController
@RefreshScope
@RequestMapping("/user")
public class UserController  {
    //private final static Logger logger= LoggerFactory.getLogger(UserController.class); implements ITxTransaction
    protected final static Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    UserFeignClient ufc;

    @Resource
    IntegralService integralService;

    @RequestMapping(value = "/getUser/{userAccount}",method = RequestMethod.GET)
    public String getUser(@PathVariable("userAccount") String userAccount) {
        logger.debug("debug");
        logger.info("info");
        return this.ufc.getUser(userAccount);
    }

    /**
     * redis sesion共享
     *
     * @param request
     * @return
     */
    @GetMapping("/getUserSession")
    public String getUser(HttpServletRequest request) {
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        if (StringUtils.isEmpty(username)) {
            username = "testSessionRedis|" + System.currentTimeMillis();
            session.setAttribute("username", username);
            System.out.println("初台化session：");
        }
        System.out.println("访问端口：" + request.getServerPort());
        return username;
    }

    /**
     * 测试分布式事务
     * @param userAccount
     * @param integral
     * @return
     */
//    @TxTransaction(isStart = true)
//    @Transactional
    @RequestMapping(value = "/insertUser/{userAccount}/{userName}/{integral}",method = RequestMethod.POST)
    public String addUser(@PathVariable("userAccount") String userAccount,@PathVariable("userName") String userName,@PathVariable("integral") Integer integral) {
//        ufc.insert(userAccount,userName);
        Integral integralobj=new Integral() ;
        integralobj.setUserAccount(userAccount);
        integralobj.setIntegral(integral);
        try {
            integralService.insertIntegral(integralobj);
            return "事务成功";
        }catch (Exception e){
            return "事务失败";
        }
    }
}
