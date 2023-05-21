package com.zxy.mapper;

import com.zxy.entity.CityFood;


import java.util.List;

public interface FoodMapper {
    List<CityFood> getAllFood(String Cname);
    void insertFood(CityFood cityFood);

    CityFood getFoodByFname(String Fname);
    void updateFood(CityFood cityFood);
    void deleteFood(String Fno);

    CityFood getCname(int Fno);
}
