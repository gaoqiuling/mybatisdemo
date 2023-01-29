package com.itisacat.mybatisplusdemo.dataobject;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

/**
 * 用户 DO
 */
@TableName(value = "sys_user")
public class UserDO {

    public Integer getUserId() {
        return user_id;
    }

    public void setUserId(Integer userId) {
        this.user_id = userId;
    }


    @TableId(type = IdType.AUTO)
    private Integer user_id;
    /**
     * 账号
     */
    private String userName;

    public String getUserName() {
        return userName;
    }

    public UserDO setUsername(String username) {
        this.userName = username;
        return this;
    }

}
