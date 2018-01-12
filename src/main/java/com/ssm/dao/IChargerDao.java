package com.ssm.dao;

import com.ssm.bean.Charger;

import java.util.List;
import java.util.Map;

public interface IChargerDao {
    List<Charger> queryAll();

    int update(Map<String, Object> param);

    Charger queryOne(Map<String, Object> param3);
}
