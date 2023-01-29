package com.itisacat.mybatisdemo.mapper;

import com.itisacat.mybatisdemo.dataobject.UserDO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    UserDO selectByUsername(@Param("username") String username);
}
