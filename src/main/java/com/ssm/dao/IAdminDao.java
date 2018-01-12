package com.ssm.dao;

import com.ssm.bean.Admin;

import java.util.List;
import java.util.Map;

public interface IAdminDao {
    List<Admin> getAdmin(Map<String, Object> param);

    int updatePwd(Map<String, Object> param);
}
