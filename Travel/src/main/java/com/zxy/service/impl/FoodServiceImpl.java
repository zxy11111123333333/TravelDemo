package com.zxy.service.impl;

import com.zxy.entity.CityFood;
import com.zxy.mapper.CityMapper;
import com.zxy.mapper.FoodMapper;
import com.zxy.service.FoodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FoodServiceImpl implements FoodService {
    @Autowired
    private FoodMapper foodMapper;
    @Override
    public List<CityFood> getAllFood(String Cname) {
        return foodMapper.getAllFood(Cname);
    }

    @Override
    public void insertFood(CityFood cityFood) {
        foodMapper.insertFood(cityFood);
    }

    @Override
    public CityFood getFoodByFname(String Fname) {
        return foodMapper.getFoodByFname(Fname);
    }

    @Override
    public void updateFood(CityFood cityFood) {
        foodMapper.updateFood(cityFood);
    }

    @Override
    public void deleteFood(String Fno) {
        foodMapper.deleteFood(Fno);
    }

    @Override
    public CityFood getCname(int Fno) {
        return foodMapper.getCname(Fno);
    }
}
