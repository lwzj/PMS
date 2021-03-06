package com.ssm.service.impl;

import com.ssm.bean.Admin;
import com.ssm.dao.IAdminDao;
import com.ssm.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("adminService")
public class AdminServiceImpl implements IAdminService{

    @Autowired
    private IAdminDao adminDao;
    public List<Admin> getAdmin(Map<String, Object> param) {
        return adminDao.getAdmin(param);
    }

    public int updatePwd(Map<String, Object> param) {
        return adminDao.updatePwd(param);
    }

}
