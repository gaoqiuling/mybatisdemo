package com.itisacat.mybatisplusdemo.mapper;

import com.itisacat.mybatisdemo.Application;
import com.itisacat.mybatisdemo.dataobject.UserDO;
import com.itisacat.mybatisdemo.mapper.UserMapper;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = Application.class)
public class UserMapperTest {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private SqlSessionFactory sqlSessionFactory;


    @Test
    public void testConfiguration() throws IOException {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        Configuration configuration = sqlSession.getConfiguration();
        UserMapper userMapper1 = sqlSession.getMapper(UserMapper.class);
        UserDO userDO = userMapper1.selectByUsername("admin");
        System.out.println(userDO.getUserName());
    }

    @Test
    public void testSelectByUsername() throws IOException {
        System.out.println("开始执行sql");
        UserDO userDO = userMapper.selectByUsername("admin");
        System.out.println(userDO.getUserName());
    }
}
