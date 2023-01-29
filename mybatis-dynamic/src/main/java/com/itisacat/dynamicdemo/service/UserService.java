package com.itisacat.dynamicdemo.service;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.itisacat.dynamicdemo.constant.DBConstants;
import com.itisacat.dynamicdemo.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Transactional
    @DS(DBConstants.DATASOURCE_RUOYI)
    public void method01() {
        System.out.println(userMapper.getFirstUserId());
    }

    @Transactional
    @DS(DBConstants.DATASOURCE_ZHIGOU)
    public void method02() {
        System.out.println(userMapper.getFirstUserId());
    }
}
