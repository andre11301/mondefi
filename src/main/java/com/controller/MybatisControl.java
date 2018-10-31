package com.controller;

import com.domain.User;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * c'est pour le test de mybatis
 */

@RestController
public class MybatisControl {

    @Autowired
    private UserService userService;

    @RequestMapping("boot/user")
    public Object getUser(){
        return userService.getUser();
    }
    @RequestMapping("/boot/update/{id}/{name}")
    public Object updateUser(@PathVariable("id") Integer id, @PathVariable("name") String name){
        User user = userService.getUserByid(id);
        user.setUsername(name);
        return userService.updateUser(user);
    }

}
