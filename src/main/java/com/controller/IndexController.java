package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**

 *  Controller layer for index page

 * @author andre

 * @Time 2018/10/29

 *

 */
@Controller
public class IndexController {
    /**
     * redirect to index page
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public   String index(Model model)
    {
        return "index";
    }
}
