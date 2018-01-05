package com.ssm.service;

import com.ssm.bean.Park;

import java.util.List;
import java.util.Map;

public interface IParkService {
    List<Park> queryAll();

    List<Park> queryUserByCarId(Map<String, Object> param);
}
