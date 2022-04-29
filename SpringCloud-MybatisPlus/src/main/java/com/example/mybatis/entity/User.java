package com.example.mybatis.entity;

import com.baomidou.mybatisplus.annotation.*;

@TableName("tb_user")
public class User {
    @TableId(value = "user_id" , type = IdType.AUTO)
    private Integer userId;

    @TableField("user_name")
    private String name;

    @TableField("passwd")
    private String passwd;

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
}
