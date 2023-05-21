package com.zxy.service;

import com.zxy.entity.*;

import java.util.List;

public interface CityService {
    List<City> getAllCity(int pageNo);
    int selectTotalCount();
    void insertCity(City city);
    boolean searchCity(String Cname);

}
