package com.controller;


import com.domain.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
public class loginController {
    @Autowired
    private UserService userService;
    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView){
        modelAndView.setViewName("login");
        return modelAndView;
    }
    @PostMapping("/login")
    public ModelAndView  login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session
                        ){

        User userResult = (User) userService.getUserByUserNameAndPwd(username,password);
        System.out.println(userResult);
        ModelAndView modelAndView = new ModelAndView();
        if(userResult != null)
        {
            modelAndView.setViewName("detail");
            modelAndView.addObject("username", userResult.getUsername());
        }else{
            modelAndView.setViewName("login");
            modelAndView.addObject("error","login error");
        }
        return modelAndView;
    }
}
