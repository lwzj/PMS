package com.ssm.service;

import com.ssm.bean.Park;
import com.ssm.bean.User;

import java.util.List;
import java.util.Map;

public interface IUserService {
    List<User> getUser(Map<String, Object> param);

    int addUser(Map<String, Object> param);

    List<User> queryAll();

    List<User> queryUserByCarId(Map<String, Object> param);
}
