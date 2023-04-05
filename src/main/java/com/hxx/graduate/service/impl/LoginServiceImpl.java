package com.hxx.graduate.service.impl;

import com.hxx.graduate.dao.LoginDao;
import com.hxx.graduate.entity.User;
import com.hxx.graduate.service.LoginService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {
    @Resource
    LoginDao loginDao;

    @Override
    public Map<String, Object> login(User user) {
        Map<String, Object> map = new HashMap<>();
        String roleid = loginDao.getRoleByAccount(user.getAccount());
        if (roleid == null) {
            map.put("errorMsg","该账户不存在！");
            return map;
        }
        if (roleid.equals("1")) {
            User amdin = loginDao.getAdminInfoByAccont(user.getAccount(), user.getLip());
            map.put("user",amdin);
        }
        return map;
    }
}
