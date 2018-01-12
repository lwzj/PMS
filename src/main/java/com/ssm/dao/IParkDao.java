package com.ssm.dao;

import com.ssm.bean.Park;
import com.ssm.bean.dto.ParkDTA;

import java.util.List;
import java.util.Map;

public interface IParkDao {
    List<Park> queryAll();

    List<Park> queryParkByCarId(Map<String, Object> param);

    List<ParkDTA> queryParking();

    List<Park> queryParkingByCarId(Map<String, Object> param);

    int tingche(Map<String, Object> param);

    int chuche(Map<String, Object> param);
}
