package com.zxy.mapper;

import com.zxy.entity.*;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface CityMapper {
    List<City> getAllCity(int pageNo);
    int selectTotalCount();
    void insertCity(City city);
    int searchCity(String Cname);

}
