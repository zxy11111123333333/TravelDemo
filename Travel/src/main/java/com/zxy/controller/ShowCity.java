package com.zxy.controller;
import com.zxy.entity.City;
import com.zxy.mapper.CityMapper;
import com.zxy.service.impl.CityServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class ShowCity{
    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private CityServiceImpl cityService;

    @ResponseBody
    @RequestMapping("/totalcity")
    public ModelAndView showallcity(@RequestParam(value = "pageNo", defaultValue = "1", required = false) int pageNo, ModelAndView modelAndView
    ,@RequestParam(value = "keyword",  required = false)String cname
            , HttpServletResponse response) throws IOException {
        int getpage=(pageNo-1)*3;
        List<City> list= cityMapper.getAllCity(getpage);
        modelAndView.addObject("cityList", list);

        int totalCount=cityMapper.selectTotalCount();
        int totalPage=(totalCount % 3)==0 ? totalCount/3 : totalCount/3+1;


        Map<String, Object> map = new HashMap<>();
        map.put("currentPage", pageNo);
        map.put("totalPage", totalPage);
        modelAndView.addAllObjects(map);
        modelAndView.setViewName("totalcity");


        if(cname!=null&&cityService.searchCity(cname)){
            String message = URLEncoder.encode(cname,"UTF-8");
            response.sendRedirect("/citydetil?cname="+message);

        }
        return modelAndView;

    }



}
