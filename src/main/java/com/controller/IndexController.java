package com.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
    //add log
    Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * redirect to index page
     * @param model
     * @return
     */
    @RequestMapping("/index")
    public   String index(Model model)
    {
        logger.trace("index");
        return "index";
    }
}
