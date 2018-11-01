package com.controller;


import com.domain.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class DetailController {
    @PostMapping("/detail")
    public Object detail(){
        User user = new User();
        user.setUsername("bb");
        return user;
    }
    @GetMapping("/detail")
    public String detail1(){
        return "detail";
    }
}
