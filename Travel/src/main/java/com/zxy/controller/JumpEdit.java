package com.zxy.controller;
import com.zxy.entity.CityFood;
import com.zxy.entity.CityHotel;
import com.zxy.entity.CityLon;
import com.zxy.service.impl.FoodServiceImpl;
import com.zxy.service.impl.HotelServiceImpl;
import com.zxy.service.impl.LonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.io.IOException;

@Controller
public class JumpEdit {
    @Autowired
    private FoodServiceImpl foodService;
    @Autowired
    private HotelServiceImpl hotelService;
    @Autowired
    private LonServiceImpl lonService;


    @RequestMapping(value = "/editFood")
    @ResponseBody
    public ModelAndView editFood(@RequestParam(value = "fname",required = true) String fname
            , ModelAndView modelAndView) throws IOException {
        CityFood cityFood=foodService.getFoodByFname(fname);
        modelAndView.addObject("food",cityFood);
        return modelAndView;
    }

    @RequestMapping(value = "/editLon")
    @ResponseBody
    public ModelAndView editLon(@RequestParam(value = "lname",required = true) String lname
            , ModelAndView modelAndView) throws IOException {
        CityLon cityLon=lonService.getLonByLname(lname);
        modelAndView.addObject("lon",cityLon);
        return modelAndView;
    }

    @RequestMapping(value = "/editHotel")
    @ResponseBody
    public ModelAndView editHotel(@RequestParam(value = "hname",required = true) String hname
            , ModelAndView modelAndView) throws IOException {
        CityHotel cityHotel=hotelService.getHotelByHname(hname);
        modelAndView.addObject("hotel",cityHotel);
        return modelAndView;
    }
}
