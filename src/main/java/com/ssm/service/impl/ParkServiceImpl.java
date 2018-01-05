package com.ssm.service.impl;

import com.ssm.bean.Park;
import com.ssm.dao.IParkDao;
import com.ssm.service.IParkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("parkService")
public class ParkServiceImpl implements IParkService{
    @Autowired
    private IParkDao parkDao;
    public List<Park> queryAll() {
        return parkDao.queryAll();
    }

    public List<Park> queryUserByCarId(Map<String, Object> param) {
        return parkDao.queryUserByCarId(param);
    }
}
