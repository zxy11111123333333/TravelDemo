package com.zxy.service.impl;

import com.zxy.entity.*;
import com.zxy.mapper.CityMapper;
import com.zxy.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityServiceImpl implements CityService {
    @Autowired
    private CityMapper cityMapper;
    @Override
    public List<City> getAllCity(int pageNo) {
        return cityMapper.getAllCity(pageNo);
    }

    @Override
    public int selectTotalCount() {
        return cityMapper.selectTotalCount();
    }

    @Override
    public void insertCity(City city) {
        cityMapper.insertCity(city);
    }

    @Override
    public boolean searchCity(String Cname) {
        if (cityMapper.searchCity(Cname)==1){
            return true;
        }
        return false;

    }

}
