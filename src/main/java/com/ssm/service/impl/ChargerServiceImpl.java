package com.ssm.service.impl;

import com.ssm.bean.Charger;
import com.ssm.dao.IChargerDao;
import com.ssm.service.IChargerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("chargerService")
public class ChargerServiceImpl implements IChargerService{
    @Autowired
    private IChargerDao chargerDao;
    public List<Charger> queryAll() {
        return chargerDao.queryAll();
    }
}
