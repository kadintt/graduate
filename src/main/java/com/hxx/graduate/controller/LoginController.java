package com.hxx.graduate.controller;


import com.hxx.graduate.entity.User;
import com.hxx.graduate.service.LoginService;
import com.hxx.graduate.utils.JWTUtil;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Resource
    LoginService loginService;

    @RequestMapping("api/login")
    public Map<String, Object> login(@RequestBody User user) {
        System.out.println(user.getAccount());
        Map<String, Object> resultMap = new HashMap<>();
        // 用户登录
        Map<String, Object> map =  loginService.login(user);
        User u = (User) map.get("user");
        if (u != null) {
            Map<String, String> payload = new HashMap<>();
            payload.put("id", String.valueOf(u.getId()));
            payload.put("account", u.getAccount());
            payload.put("role", u.getRoleId());
            payload.put("name",u.getIns_name());
            payload.put("headurl",u.getImg_url());
            // 生成token
            String token = JWTUtil.getToken(payload);
            resultMap.put("status", "1");
            resultMap.put("msg", "登录成功");
            resultMap.put("token", token); // 响应token，存储在客户端
            resultMap.put("user",u);
        }else  {
            String errorStr = (String) map.get("errorMsg");
            if (errorStr == null) {
                errorStr = "账号或密码错误";
            }
            resultMap.put("status","-1");
            resultMap.put("errorMsg",errorStr);
        }
        return resultMap;
    }
}
