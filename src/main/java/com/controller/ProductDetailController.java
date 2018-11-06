package com.controller;


import com.domain.ProductDetail;
import com.service.ProductDetailService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**

 *  Controller layer for detail page

 * @author andre

 * @Time 2018/10/29

 *

 */
@RestController
public class ProductDetailController {
    @Autowired
    private ProductDetailService productDetailService;

    //add log
    Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * get all the product info
     * @return
     */
    @PostMapping("/detail")
    //get all the product infos
    public Object detail(){
        logger.trace("detail(PostMapping)");
       List<ProductDetail> productDetailList = (List<ProductDetail>) productDetailService.getAllProduct();
       logger.info("detail","productDetailList:"+productDetailList);
       return productDetailList;
    }

    /**
     * redirect to detail page
     * @return
     */
    @GetMapping("/detail")
    public String detail1(){
        logger.trace("detail(GetMapping)");
        return "detail";
    }
}
