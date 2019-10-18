package com.hqz.springcloudconsumer.dao;

import com.hqz.springcloudconsumer.entity.Integral;

public interface IntegralMapper {
    int deleteByPrimaryKey(String userAccount);

    int insert(Integral record);

    int insertSelective(Integral record);

    Integral selectByPrimaryKey(String userAccount);

    int updateByPrimaryKeySelective(Integral record);

    int updateByPrimaryKey(Integral record);
}