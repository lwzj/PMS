package com.ssm.dao;

import com.ssm.bean.SitInfor;

import java.util.List;
import java.util.Map;

public interface ISitInforDao {
    List<SitInfor> queryFree();

    SitInfor queryByStationid(Map<String, Object> param2);
}
