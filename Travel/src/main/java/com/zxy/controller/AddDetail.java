package com.zxy.controller;

import com.zxy.entity.*;
import com.zxy.service.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
public class AddDetail {
    @Autowired
    private FoodServiceImpl foodService;
    @Autowired
    private HotelServiceImpl hotelService;
    @Autowired
    private LonServiceImpl lonService;
    @Autowired
    private TranServiceImpl tranService;

    @RequestMapping("/food")
    @ResponseBody
    public ModelAndView addFood(@RequestParam(value = "cname") String cname
            , @RequestParam(value = "fname")String fname
            , @RequestParam(value = "fin")String fin
            , @RequestParam(value = "fimg")String fimg
            , HttpServletResponse response, HttpServletRequest request) throws IOException {
        CityFood cityFood=new CityFood(cname,fname,fin,fimg);
        User user= (User) request.getSession().getAttribute("user");
        cityFood.setUno(user.getUno());
        foodService.insertFood(cityFood);
        String message = URLEncoder.encode(cname,"UTF-8");
        response.sendRedirect("/citydetil?cname="+message);
        return null;
    }



    @RequestMapping("/hotel")
    @ResponseBody
    public ModelAndView addHotel(@RequestParam(value = "cname") String cname
            , @RequestParam(value = "hname")String hname
            , @RequestParam(value = "hin")String hin
            , @RequestParam(value = "himg")String himg
            , HttpServletResponse response) throws IOException {
        CityHotel cityHotel=new CityHotel(cname,hname,hin,himg);
        hotelService.insertHotel(cityHotel);
        String message = URLEncoder.encode(cname,"UTF-8");
        response.sendRedirect("/citydetil?cname="+message);
        return null;
    }

    @RequestMapping("/lon")
    @ResponseBody
    public ModelAndView addLon(@RequestParam(value = "cname") String cname
            , @RequestParam(value = "lname")String lname
            , @RequestParam(value = "lin")String lin
            , @RequestParam(value = "limg")String limg
            , HttpServletResponse response) throws IOException {
        CityLon cityLon=new CityLon(cname,lname,lin,limg);
        lonService.insertLon(cityLon);
        String message = URLEncoder.encode(cname,"UTF-8");
        response.sendRedirect("/citydetil?cname="+message);
        return null;
    }

    @RequestMapping("/tran")
    @ResponseBody
    public ModelAndView addTran(@RequestParam(value = "cname") String cname
            , @RequestParam(value = "tname")String tname
            , HttpServletResponse response) throws IOException {
        CityTran cityTran=new CityTran(cname,tname);
        tranService.insertTran(cityTran);
        String message = URLEncoder.encode(cname,"UTF-8");
        response.sendRedirect("/citydetil?cname="+message);
        return null;
    }

}
