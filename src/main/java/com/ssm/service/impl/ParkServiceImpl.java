package com.ssm.service.impl;

import com.ssm.bean.Charger;
import com.ssm.bean.Park;
import com.ssm.bean.SitInfor;
import com.ssm.bean.User;
import com.ssm.bean.dto.ParkDTA;
import com.ssm.dao.IChargerDao;
import com.ssm.dao.IParkDao;
import com.ssm.dao.ISitInforDao;
import com.ssm.dao.IUserDao;
import com.ssm.service.IParkService;
import com.ssm.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service("parkService")
public class ParkServiceImpl implements IParkService{
    @Autowired
    private IParkDao parkDao;
    @Autowired
    private IUserDao userDao;
    @Autowired
    private ISitInforDao sitInforDao;
    @Autowired
    private IChargerDao chargerDao;
    public List<Park> queryAll() {
        return parkDao.queryAll();
    }

    public List<Park> queryUserByCarId(Map<String, Object> param) {
        return parkDao.queryParkByCarId(param);
    }

    public List<ParkDTA> queryParking() {
        return parkDao.queryParking();
    }

    public List<Park> queryParkingByCarId(Map<String, Object> param) {
        return parkDao.queryParkingByCarId(param);
    }

    public int tingche(Map<String, Object> param) {
        String date = DateUtil.DateToStr(new Date());
        param.put("startpark", date);
        return parkDao.tingche(param);
    }

    public Park chuche(Map<String, Object> param) {
        List<ParkDTA> parks = parkDao.queryParking();
        String usertype = null;
        String stationtype = null;
        Date time = new Date();
        int charger = 0;
        Park  park = null;
        for (ParkDTA parkDTA:parks
             ) {
            if (parkDTA.getCarId().equals(param.get("carId"))) {
                park.setStartpark(parkDTA.getStartpark());
                park.setCarId(parkDTA.getCarId());
                park.setId(parkDTA.getId());
                park.setStationid(parkDTA.getStationid());
                time = parkDTA.getStartpark();
                param.put("id", parkDTA.getId());
                Map<String, Object> param1 = new HashMap<String, Object>();
                Map<String, Object> param2 = new HashMap<String, Object>();
                Map<String, Object> param3 = new HashMap<String, Object>();
                param1.put("carId", parkDTA.getCarId());
                param2.put("stationid", parkDTA.getStationid());
                List<User> users = userDao.queryUserByCarId(param1);
                if (users.size() > 0) {
                    usertype = users.get(0).getUsertype();
                }
                SitInfor sitInfor = sitInforDao.queryByStationid(param2);
                if (sitInfor != null) {
                    stationtype = sitInfor.getStationtype();
                }
                param3.put("usertype",usertype );
                param3.put("stationtype",stationtype );
                Charger charger1 = chargerDao.queryOne(param3);
                if (charger1 != null) {
                    charger = charger1.getCharge();
                }
            }
        }
        Date time2 = new Date();
        park.setEndpark(time2);
        String date = DateUtil.DateToStr(time2);
        long l = time2.getTime() - time.getTime();
        int d = (int) (l/(1000*60*60));
        int fee = d*charger;
        park.setFee(fee);

        param.put("endpark", date);
        param.put("fee", fee);

        parkDao.chuche(param);
        return park;
    }

}
