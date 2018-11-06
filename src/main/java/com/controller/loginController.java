package com.controller;


import com.domain.User;
import com.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;
/**

 *  Controller layer for login page

 * @author andre

 * @Time 2018/10/29

 *

 */
@RestController
public class loginController {
    @Autowired
    private UserService userService;
    //add log
    Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * redirect to login page
     * @param modelAndView
     * @return
     */
    @GetMapping("/login")
    public ModelAndView login(ModelAndView modelAndView){
        logger.trace("login(GetMapping)");
        modelAndView.setViewName("login");
        return modelAndView;
    }

    /**
     * login validate
     * @param username
     * @param password
     * @param session
     * @return
     */
    @PostMapping("/login")
    public ModelAndView  login(@RequestParam("username") String username,
                        @RequestParam("password") String password,
                        HttpSession session
                        ){
        logger.trace("login(PostMapping)");
        User userResult = (User) userService.getUserByUserNameAndPwd(username,password);
        ModelAndView modelAndView = new ModelAndView();
        if(userResult != null)
        {
            modelAndView.setViewName("detail");
            modelAndView.addObject("username", userResult.getUsername());
            session.setAttribute("username",username);
        }else{
            modelAndView.setViewName("login");
            modelAndView.addObject("error","login error");
            logger.info("login error",username);
        }
        return modelAndView;
    }
}
