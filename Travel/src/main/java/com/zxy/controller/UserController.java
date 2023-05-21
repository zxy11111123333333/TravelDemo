package com.zxy.controller;

import com.zxy.entity.CityLon;
import com.zxy.entity.User;
import com.zxy.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl userService;

    @RequestMapping("/userregister")
    @ResponseBody
    public ModelAndView userRegister(@RequestParam(value = "Username") String Username
            , @RequestParam(value = "Password")String Password
            , HttpServletResponse response) throws IOException {
        if(Username.equals("")||Password.equals("")){
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.print("<script>alert('请输入信息'); window.location.href='/login.html' </script>");
            out.flush();
            out.close();
        }else{
            User user=new User(Username,Password);
            userService.insertUser(user);
            response.sendRedirect("/first.html");
        }

        return null;
    }

    @RequestMapping("/userlogin")
    @ResponseBody
    public ModelAndView userLogin(@RequestParam(value = "Username") String Username
            , @RequestParam(value = "Password")String Password
            , HttpServletResponse response, HttpServletRequest request) throws IOException {
        int count=userService.haveUser(Username);
        if(count==0){
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.print("<script>alert('用户不存在'); window.location.href='/login.html' </script>");
            out.flush();
            out.close();
        }

        User user=userService.searchUser(Username);
        if(user.getUpass().equals(Password)){
            HttpSession session= request.getSession();
            session.setAttribute("user",user);
            response.sendRedirect("/first.html");
        }else{
            response.setCharacterEncoding("utf-8");
            response.setContentType("text/html;charset=UTF-8");
            PrintWriter out = null;
            try {
                out = response.getWriter();
            } catch (IOException e) {
                e.printStackTrace();
            }
            out.print("<script>alert('登录失败'); window.location.href='/login.html' </script>");
            out.flush();
            out.close();

        }

        return null;
    }
}
