package com.itisacat.dynamicdemo.mapper;

import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper {
    Integer getFirstUserId();
}
