package com.ssm.bean;

public class Charger {
    private int id ;
    private String cardtype;
    private String stationtype;
    private int charge;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCardtype() {
        return cardtype;
    }

    public void setCardtype(String cardtype) {
        this.cardtype = cardtype;
    }

    public String getStationtype() {
        return stationtype;
    }

    public void setStationtype(String stationtype) {
        this.stationtype = stationtype;
    }

    public int getCharge() {
        return charge;
    }

    public void setCharge(int charge) {
        this.charge = charge;
    }
}
