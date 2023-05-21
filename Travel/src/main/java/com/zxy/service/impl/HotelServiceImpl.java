package com.zxy.service.impl;

import com.zxy.entity.CityHotel;
import com.zxy.mapper.FoodMapper;
import com.zxy.mapper.HotelMapper;
import com.zxy.service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    @Autowired
    private HotelMapper hotelMapper;
    @Override
    public List<CityHotel> getAllHotel(String Cname) {
        return hotelMapper.getAllHotel(Cname);
    }

    @Override
    public void insertHotel(CityHotel cityHotel) {
        hotelMapper.insertHotel(cityHotel);
    }

    @Override
    public CityHotel getHotelByHname(String Hname) {
        return hotelMapper.getHotelByHname(Hname);
    }

    @Override
    public void updateHotel(CityHotel cityHotel) {
        hotelMapper.updateHotel(cityHotel);
    }

    @Override
    public void deleteHotel(String Hno) {
        hotelMapper.deleteHotel(Hno);
    }
}
