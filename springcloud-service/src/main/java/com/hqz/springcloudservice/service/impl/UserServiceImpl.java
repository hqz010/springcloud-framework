package com.hqz.springcloudservice.service.impl;

import com.codingapi.tx.annotation.ITxTransaction;
import com.hqz.springcloudservice.dao.UserMapper;
import com.hqz.springcloudservice.entity.User;
import com.hqz.springcloudservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserServiceImpl implements UserService,ITxTransaction {

    @Autowired
    private UserMapper userMapper;

    @Override
    @Cacheable(value="user", key="'user'.concat(#user_account.toString())")
    public User getUser(String userAccount) {
        return userMapper.selectByPrimaryKey(userAccount);
    }

    @Override
    @Transactional
    public int insert(User user){
        return userMapper.insert(user);
    }
}
