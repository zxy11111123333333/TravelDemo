package com.zxy.mapper;

import com.zxy.entity.CityHotel;
import com.zxy.entity.CityLon;

import java.util.List;

public interface LonMapper {
    List<CityLon> getAllLon(String Cname);
    void insertLon(CityLon cityLon);
    CityLon getLonByLname(String Lname);
    void updateLon(CityLon cityLon);
    void deleteLon(String Lno);



}
