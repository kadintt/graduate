package com.hxx.graduate.service;

import com.hxx.graduate.entity.User;

import java.util.HashMap;
import java.util.Map;

public interface LoginService {
    Map<String, Object> login(User user);
}
