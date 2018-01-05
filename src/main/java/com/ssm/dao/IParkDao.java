package com.ssm.dao;

import com.ssm.bean.Park;

import java.util.List;
import java.util.Map;

public interface IParkDao {
    List<Park> queryAll();

    List<Park> queryUserByCarId(Map<String, Object> param);
}
