package com.zxy.controller;
import com.zxy.entity.CityFood;
import com.zxy.entity.CityHotel;
import com.zxy.entity.CityLon;
import com.zxy.entity.User;
import com.zxy.service.impl.FoodServiceImpl;
import com.zxy.service.impl.HotelServiceImpl;
import com.zxy.service.impl.LonServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

@Controller
public class EditDetail {
    @Autowired
    private FoodServiceImpl foodService;
    @Autowired
    private HotelServiceImpl hotelService;
    @Autowired
    private LonServiceImpl lonService;

    @RequestMapping("/editf")
    @ResponseBody
    public ModelAndView updatFood(@RequestParam(value = "cname") String cname
            , @RequestParam(value = "fname")String fname
            , @RequestParam(value = "fin")String fin
            , @RequestParam(value = "fimg")String fimg
            , HttpServletRequest request
            , HttpServletResponse response,HttpServletRequest req) throws IOException {
        CityFood cityFood=new CityFood(cname,fname,fin,fimg);
        foodService.updateFood(cityFood);
         String message = URLEncoder.encode(cname,"UTF-8");
       response.sendRedirect("/citydetil?cname="+message);
        return null;
    }
    @RequestMapping("/editl")
    @ResponseBody
    public ModelAndView updatLon(@RequestParam(value = "cname") String cname
            , @RequestParam(value = "lname")String lname
            , @RequestParam(value = "lin")String lin
            , @RequestParam(value = "limg")String limg
            , HttpServletResponse response) throws IOException {
        CityLon cityLon=new CityLon(cname,lname,lin,limg);
        lonService.updateLon(cityLon);
        String message = URLEncoder.encode(cname,"UTF-8");
        response.sendRedirect("/citydetil?cname="+message);
        return null;
    }
    @RequestMapping("/edith")
    @ResponseBody
    public ModelAndView updatHotel(@RequestParam(value = "cname") String cname
            , @RequestParam(value = "hname")String hname
            , @RequestParam(value = "hin")String hin
            , @RequestParam(value = "himg")String himg
            , HttpServletResponse response) throws IOException {
        CityHotel cityHotel=new CityHotel(cname,hname,hin,himg);
        hotelService.updateHotel(cityHotel);
        String message = URLEncoder.encode(cname,"UTF-8");
        response.sendRedirect("/citydetil?cname="+message);
        return null;
    }
}
