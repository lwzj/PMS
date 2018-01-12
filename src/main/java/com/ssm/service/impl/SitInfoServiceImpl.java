package com.ssm.service.impl;

import com.ssm.bean.SitInfor;
import com.ssm.dao.ISitInforDao;
import com.ssm.service.ISitInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("sitInfoService")
public class SitInfoServiceImpl implements ISitInfoService{
    @Autowired
    private ISitInforDao sitInforDao;
    public List<SitInfor> queryFree() {
        return sitInforDao.queryFree();
    }
}
