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

    public List<User> queryUserById(Map<String, Object> param) {
        return userDao.queryUserById(param);
    }

    public int charger(Map<String, Object> param) {

        List<User> users = userDao.queryUserById(param);
        int money = Integer.parseInt(param.get("money").toString());
        int m = users.get(0).getMoney() + money;
        param.put("money",m);
        return userDao.update(param);
    }

    public int updatePwd(Map<String, Object> param) {
        return userDao.updatePwd(param);
    }

    public int updateInfo(Map<String, Object> param) {
        return userDao.updateInfo(param);
    }
}
