package com.itisacat.mybatisplusdemo.mapper;

import com.itisacat.mybatisplusdemo.Application;
import com.itisacat.mybatisplusdemo.dataobject.UserDO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectById() {
        System.out.println("mybatisplus 初始化已完成");
        UserDO userDO = userMapper.selectById(1);
        System.out.println(userDO.getUserName());
    }
}
