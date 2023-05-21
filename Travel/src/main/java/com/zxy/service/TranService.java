package com.zxy.service;

import com.zxy.entity.CityTran;

import java.util.List;

public interface TranService {
    List<CityTran> getAllTran(String Cname);
    void insertTran(CityTran cityTran);
    void deleteTran(String Tno);
}
