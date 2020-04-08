package com.csdj.dwc.service;

import com.csdj.dwc.mapper.DriverSchoolMapper;
import com.csdj.dwc.pojo.CityArea;
import com.csdj.dwc.pojo.DriverSchool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DriverSchoolService {

    @Autowired
    private DriverSchoolMapper mapper;

    public List<CityArea> cityAreas(){return mapper.cityArea();}

    public List<DriverSchool> getAllInfo(int page,int limit){
        return mapper.getAllInfo(page,limit);
    }

    public List<DriverSchool> getInfoById(int page,int limit,String id){
        return mapper.getInfoById(page,limit,id);
    }

    public int count(){return mapper.count();}

    public DriverSchool getDriverInfoById(int id){
        return mapper.getDriverInfoById(id);
    }

    public int updDriver(DriverSchool driverSchool){
        return mapper.updDriver(driverSchool);
    }

    public int add(DriverSchool driverSchool){return mapper.add(driverSchool);}

    public int del(int id){return mapper.del(id);}
}
