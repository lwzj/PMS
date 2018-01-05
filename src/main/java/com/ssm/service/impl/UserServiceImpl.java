package com.ssm.service.impl;

import com.ssm.bean.Park;
import com.ssm.bean.User;
import com.ssm.dao.IUserDao;
import com.ssm.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("userService")
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserDao userDao;

    public List<User> getUser(Map<String, Object> param) {
        return userDao.getUser(param);
    }

    public int addUser(Map<String, Object> param) {
        return userDao.addUser(param);
    }

    public List<User> queryAll() {
        return userDao.findAll();
    }

    public List<User> queryUserByCarId(Map<String, Object> param) {
        return userDao.queryUserByCarId(param);
    }
}
