package com.hxx.graduate.entity;

import lombok.Data;

@Data
public class User {
    String account; //账号
    String lip; // 密码
    String roleId; //权限id 1系统管理员 2学院管理员 3导员 4学生
    String Id; // 用户id
    String img_url; //用户头像
    String ins_name;
    String phone;
    String address;
}
