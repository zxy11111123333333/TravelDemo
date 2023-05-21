package com.zxy.service.impl;

import com.zxy.entity.CityTran;
import com.zxy.mapper.LonMapper;
import com.zxy.mapper.TranMapper;
import com.zxy.service.TranService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TranServiceImpl implements TranService {
    @Autowired
    private TranMapper tranMapper;
    @Override
    public List<CityTran> getAllTran(String Cname) {
        return tranMapper.getAllTran(Cname);
    }

    @Override
    public void insertTran(CityTran cityTran) {
        tranMapper.insertTran(cityTran);
    }

    @Override
    public void deleteTran(String Tno) {
        tranMapper.deleteTran(Tno);
    }
}
