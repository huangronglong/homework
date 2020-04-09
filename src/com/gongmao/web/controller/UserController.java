package com.gongmao.web.controller;

import com.gongmao.web.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/StudentController")
public class UserController {

    @RequestMapping("/addUser")
    public ModelAndView addUser(@RequestParam("id") int id,@RequestParam("username")String name,@RequestParam("password") String password){
        User user=new User(id,name,password);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("../user-list.jsp");
        mv.addObject("userInfo",user);
        return mv;
    }

    @RequestMapping("/login")
    public ModelAndView login(@RequestParam("username")String name,@RequestParam("password") String password){
        ModelAndView mv=new ModelAndView();
        if (name.equals("admin")&&password.equals("admin")) {
            mv.setViewName("../main.jsp");
        }else {
            mv.setViewName("../login.jsp");
        }
        return mv;
    }
    @RequestMapping("/updUser")
    public ModelAndView updUser(@RequestParam("id") int id,@RequestParam("username")String name,@RequestParam("password") String password){
        ModelAndView mv=new ModelAndView();
        User user=new User(id,name,password);
        mv.setViewName("../user-list.jsp");
        mv.addObject("upduser",user);
        return mv;

    }


}
