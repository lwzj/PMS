package com.ssm.dao;

import com.ssm.bean.Park;
import com.ssm.bean.User;

import java.util.List;
import java.util.Map;

public interface IUserDao {

    List<User> getUser(Map<String, Object> param);

   int addUser(Map<String, Object> param);

    List<User> findAll();

    List<User> queryUserByCarId(Map<String, Object> param);
}
