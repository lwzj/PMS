package com.ssm.service;

import com.ssm.bean.Charger;

import java.util.List;
import java.util.Map;

public interface IChargerService {
    List<Charger> queryAll();

    int charger(Map<String, Object> param);
}
