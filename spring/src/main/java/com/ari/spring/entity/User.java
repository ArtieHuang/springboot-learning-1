package com.ari.spring.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.Value;


@Data
@TableName(value = "sys_user")
public class User {
    @TableId(type= IdType.AUTO)
    private Integer id;
    private String username;
    @JsonIgnore  //忽略json
    private String password;
    private String nickname;
    private String email;
    private String phone;
    private String address;
    private String create_time;
    @TableField(value="avatar_url")         //指定数据库名称
    private String avatarUrl;
}
