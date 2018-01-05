package com.ssm.service;

import com.ssm.bean.Admin;

import java.util.List;
import java.util.Map;

public interface IAdminService {
    List<Admin> getAdmin(Map<String, Object> param);
}
