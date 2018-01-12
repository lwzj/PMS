package com.ssm.bean.dto;

import java.util.Date;

public class ParkDTA {
    private int id;
    //车牌号
    private String carId;
    //车位id
    private int stationid;
    //入库时间
    private Date startpark;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public int getStationid() {
        return stationid;
    }

    public void setStationid(int stationid) {
        this.stationid = stationid;
    }

    public Date getStartpark() {
        return startpark;
    }

    public void setStartpark(Date startpark) {
        this.startpark = startpark;
    }
}
