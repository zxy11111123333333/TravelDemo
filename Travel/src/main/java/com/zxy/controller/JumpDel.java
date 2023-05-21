package com.zxy.controller;

import com.zxy.service.impl.FoodServiceImpl;
import com.zxy.service.impl.HotelServiceImpl;
import com.zxy.service.impl.LonServiceImpl;
import com.zxy.service.impl.TranServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Controller
public class JumpDel {
    @Autowired
    private FoodServiceImpl foodService;
    @Autowired
    private HotelServiceImpl hotelService;
    @Autowired
    private LonServiceImpl lonService;
    @Autowired
    private TranServiceImpl tranService;


    @RequestMapping(value = "/delfood")
    @ResponseBody
    ModelAndView delFood(@RequestParam(value = "fno") String fno
            , HttpServletResponse response
            , ModelAndView modelAndView) throws IOException {
        foodService.deleteFood(fno);

        return null;
    }

    @RequestMapping(value = "/dellon")
    @ResponseBody
    ModelAndView delLon(@RequestParam(value = "lno") String lno
            , HttpServletResponse response
            , ModelAndView modelAndView) throws IOException {
        lonService.deleteLon(lno);

        return null;
    }

    @RequestMapping(value = "/delhotel")
    @ResponseBody
    ModelAndView delHotel(@RequestParam(value = "hno") String hno
            , HttpServletResponse response
            , ModelAndView modelAndView) throws IOException {
        hotelService.deleteHotel(hno);
        response.sendRedirect("/totalcity");
        return null;
    }

    @RequestMapping(value = "/deltran")
    @ResponseBody
    ModelAndView delTran(@RequestParam(value = "tno") String tno
            , HttpServletResponse response
            , ModelAndView modelAndView) throws IOException {
        tranService.deleteTran(tno);
        response.sendRedirect("/totalcity");
        return null;
    }



}
