package com.zxy.mapper;

import com.zxy.entity.CityLon;
import com.zxy.entity.CityTran;

import java.util.List;

public interface TranMapper {

    List<CityTran> getAllTran(String Cname);
    void insertTran(CityTran cityTran);
    void deleteTran(String Tno);

}
