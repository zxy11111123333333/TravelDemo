package com.zxy.controller;

import com.zxy.entity.*;
import com.zxy.mapper.*;
import com.zxy.service.impl.FoodServiceImpl;
import com.zxy.service.impl.HotelServiceImpl;
import com.zxy.service.impl.LonServiceImpl;
import com.zxy.service.impl.TranServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.util.List;


@Controller
@RequestMapping("/citydetil")
public class CityDetial{
    @Autowired
    private FoodServiceImpl foodService;
    @Autowired
    private HotelServiceImpl hotelService;
    @Autowired
    private LonServiceImpl lonService;
    @Autowired
    private TranServiceImpl tranService;

    @ResponseBody
    @RequestMapping
    public ModelAndView mycitydetil(@RequestParam(value = "cname", defaultValue = "重庆", required = false) String Cname, ModelAndView modelAndView) {

        List<CityHotel> cityHotels= hotelService.getAllHotel(Cname);
        List<CityFood> cityFoods= foodService.getAllFood(Cname);
        List<CityLon> cityLons= lonService.getAllLon(Cname);
        List<CityTran> cityTrans= tranService.getAllTran(Cname);

        modelAndView.addObject("foodList", cityFoods);
        modelAndView.addObject("hotelList", cityHotels);
        modelAndView.addObject("lonList", cityLons);
        modelAndView.addObject("tranList", cityTrans);
        modelAndView.addObject("cname", Cname);

        modelAndView.setViewName("citydetil");
        return modelAndView;

    }

}



