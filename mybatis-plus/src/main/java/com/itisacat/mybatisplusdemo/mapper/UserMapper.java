package com.itisacat.mybatisplusdemo.mapper;

import com.itisacat.mybatisplusdemo.dataobject.UserDO;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

@Repository
public interface UserMapper extends BaseMapper<UserDO> {
}
