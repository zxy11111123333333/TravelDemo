package com.zxy.service;

import com.zxy.entity.CityFood;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FoodService {
    List<CityFood> getAllFood(String Cname);
    void insertFood(CityFood cityFood);
    CityFood getFoodByFname(String Fname);
    void updateFood(CityFood cityFood);
    void deleteFood(String Fno);
    CityFood getCname(int Fno);
}
