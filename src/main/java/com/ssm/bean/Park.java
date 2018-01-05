package com.ssm.bean;

import java.util.Date;

public class Park {
    private int id;
    //车牌号
    private String carId;
    //车位id
    private int stationid;
    //入库时间
    private Date startpark;
    //出库时间
    private Date endpark;
    //消费
    private int fee;

    public int getFee() {
        return fee;
    }

    public void setFee(int fee) {
        this.fee = fee;
    }

    public int getStationid() {
        return stationid;
    }

    public void setStationid(int stationid) {
        this.stationid = stationid;
    }

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
}
