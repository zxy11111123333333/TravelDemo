package com.zxy.service;

import com.zxy.entity.CityHotel;

import java.util.List;

public interface HotelService {
    List<CityHotel> getAllHotel(String Cname);
    void insertHotel(CityHotel cityHotel);
    CityHotel getHotelByHname(String Hname);
    void updateHotel(CityHotel cityHotel);
    void deleteHotel(String Hno);
}
