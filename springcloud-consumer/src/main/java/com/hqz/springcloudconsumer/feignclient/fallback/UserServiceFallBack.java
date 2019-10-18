package com.hqz.springcloudconsumer.feignclient.fallback;

import com.hqz.springcloudconsumer.feignclient.UserFeignClient;
import org.springframework.stereotype.Component;

@Component
public class UserServiceFallBack implements UserFeignClient {
    @Override
    public String getUser(){
        return "error 1";
    }
    @Override
    public String getUser(String userAccount){
        return "error 2";
    }

    public int insert(String userAccount,String userName){
        System.out.println("进入断路器-insert。。。");
        throw new RuntimeException("save 保存失败.");
    }
}
