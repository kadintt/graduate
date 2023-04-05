package com.hxx.graduate.dao;

import com.hxx.graduate.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LoginDao {

    User getAdminInfoByAccont(@Param("account") String account, @Param("lip") String lip);

    String getRoleByAccount(String account);
}
