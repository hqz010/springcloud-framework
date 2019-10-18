package com.hqz.springcloudconsumer.service;

import com.hqz.springcloudconsumer.entity.Integral;
import org.springframework.transaction.annotation.Transactional;

public interface IntegralService {
    @Transactional
    public int insertIntegral(Integral integral) ;
}
