package com.ssm.service;

import com.ssm.bean.Park;
import com.ssm.bean.dto.ParkDTA;

import java.util.List;
import java.util.Map;

public interface IParkService {
    List<Park> queryAll();

    List<Park> queryUserByCarId(Map<String, Object> param);

    List<ParkDTA> queryParking();

    List<Park> queryParkingByCarId(Map<String, Object> param);

    int tingche(Map<String, Object> param);

    Park chuche(Map<String, Object> param);
}
