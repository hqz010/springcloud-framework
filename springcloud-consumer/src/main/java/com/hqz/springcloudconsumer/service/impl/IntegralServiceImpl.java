package com.hqz.springcloudconsumer.service.impl;

import com.codingapi.tx.annotation.ITxTransaction;
import com.codingapi.tx.annotation.TxTransaction;
import com.hqz.springcloudconsumer.feignclient.UserFeignClient;
import com.hqz.springcloudconsumer.dao.IntegralMapper;
import com.hqz.springcloudconsumer.entity.Integral;
import com.hqz.springcloudconsumer.service.IntegralService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IntegralServiceImpl implements IntegralService,ITxTransaction {
    @Autowired
    private IntegralMapper integralMapper;

    @Autowired
    UserFeignClient ufc;

    @Override
    @TxTransaction(isStart = true)
    @Transactional
    public int insertIntegral(Integral integral) {
        int a=0,b=0;
        String userAccount = integral.getUserAccount();
        String userName = "lele";
        a = integralMapper.insert(integral);
        b = ufc.insert(userAccount, userName);
        System.out.println("执行情况："+b);
//        if(b==0) {
//            System.out.println("hello!");
//            throw new RuntimeException("333");
//        }
        //int c = 100/0;
        return a + b;
    }
}
