package com.zxy.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import java.io.IOException;

@Controller
public class JumpAdd {
    @RequestMapping("/addFood.html")
    @ResponseBody
    ModelAndView jumpFood(@RequestParam(value = "cname") String cname
            ,  ModelAndView modelAndView) throws IOException {
        modelAndView.addObject("cname", cname);
        return modelAndView;
    }


    @RequestMapping("/addHotel.html")
    @ResponseBody
    ModelAndView jumpHotel(@RequestParam(value = "cname") String cname
            ,  ModelAndView modelAndView) throws IOException {
        modelAndView.addObject("cname", cname);
        return modelAndView;
    }

    @RequestMapping("/addLon.html")
    @ResponseBody
    ModelAndView jumpLon(@RequestParam(value = "cname") String cname
            ,  ModelAndView modelAndView) throws IOException {
        modelAndView.addObject("cname", cname);
        return modelAndView;
    }

    @RequestMapping("/addTran.html")
    @ResponseBody
    ModelAndView jumpTran(@RequestParam(value = "cname") String cname
            ,  ModelAndView modelAndView) throws IOException {
        modelAndView.addObject("cname", cname);
        return modelAndView;
    }




}
