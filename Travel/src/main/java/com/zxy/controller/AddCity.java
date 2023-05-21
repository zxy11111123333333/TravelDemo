package com.zxy.controller;

import com.zxy.entity.City;
import com.zxy.mapper.CityMapper;
import com.zxy.service.CityService;
import com.zxy.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
@RequestMapping("/add")
public class AddCity {
    @Autowired
    private CityServiceImpl cityService;

    @RequestMapping
    @ResponseBody
    public ModelAndView addCity(@RequestParam(value = "cname", required = false) String cname
            , @RequestParam(value = "cin", required = false)String cin
            , HttpServletResponse response) throws IOException {

        City city=new City(cname,cin);
        cityService.insertCity(city);

        response.sendRedirect("/totalcity");
        return null;
    }
}
