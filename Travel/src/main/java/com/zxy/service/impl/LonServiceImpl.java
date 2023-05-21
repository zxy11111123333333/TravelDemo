package com.zxy.service.impl;

import com.zxy.entity.CityLon;
import com.zxy.mapper.LonMapper;
import com.zxy.service.LonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class LonServiceImpl implements LonService {

    @Autowired
    private LonMapper lonMapper;
    @Override
    public List<CityLon> getAllLon(String Cname) {
        return lonMapper.getAllLon(Cname);
    }

    @Override
    public void insertLon(CityLon cityLon) {
        lonMapper.insertLon(cityLon);
    }

    @Override
    public CityLon getLonByLname(String Lname) {
        return lonMapper.getLonByLname(Lname);
    }

    @Override
    public void updateLon(CityLon cityLon) {
        lonMapper.updateLon(cityLon);
    }

    @Override
    public void deleteLon(String Lno) {
        lonMapper.deleteLon(Lno);
    }
}
