package com.hqz.springcloudservice.controller;

import com.codingapi.tx.annotation.ITxTransaction;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hqz.springcloudservice.entity.User;
import com.hqz.springcloudservice.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.io.IOException;

@RestController
@RefreshScope
@Controller
@EnableAutoConfiguration
@RequestMapping("/user")
public class UserController implements ITxTransaction {
    @Value("${myname}") // git配置文件里的key
            String myname;

    @Resource
    private UserServiceImpl userService;
    @Autowired
    ObjectMapper mapper;

    @RequestMapping(value = "/getUser")
    public String getUser(){
        return myname;
    }

    @ResponseBody
    @RequestMapping(value = "/getUser/{userAccount}")
    public String getUser(@PathVariable String userAccount){
        User user=userService.getUser(userAccount);
        String json=null;
        try {
            json = mapper.writeValueAsString(user);

        }catch (IOException e){
            e.printStackTrace();
        }
        return json;
    }

    //@Transactional
    @RequestMapping(value="/insert/{userAccount}/{userName}",method = RequestMethod.POST)
    public int insert(@PathVariable("userAccount") String userAccount,@PathVariable("userName") String userName){
        User user=new User();
        user.setUserAccount(userAccount);
        user.setUserName(userName);
        return userService.insert(user);
    }
}
