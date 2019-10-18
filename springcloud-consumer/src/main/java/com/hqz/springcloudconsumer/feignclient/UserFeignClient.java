package com.hqz.springcloudconsumer.feignclient;


import com.hqz.springcloudconsumer.feignclient.fallback.UserServiceFallBack;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(name = "service1",fallback = UserServiceFallBack.class)
public interface UserFeignClient {
    @RequestMapping(value = "/user/getUser", method = RequestMethod.GET)
    public String getUser();

    @RequestMapping(value = "/user/getUser/{userAccount}", method = RequestMethod.GET)
    public String getUser(@PathVariable("userAccount") String userAccount);

    @RequestMapping(value="/user/insert/{userAccount}/{userName}",method = RequestMethod.POST)
    public int insert(@PathVariable("userAccount") String userAccount,@PathVariable("userName") String userName);
}
