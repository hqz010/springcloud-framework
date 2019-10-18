package com.hqz.springcloudservice.service;

import com.hqz.springcloudservice.entity.User;

public interface UserService {
    public User getUser(String userAccount);

    public int insert(User user);
}
