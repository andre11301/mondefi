package com.controller;


import com.domain.ProductDetail;
import com.domain.User;
import com.service.Imp.ProductDetailServiceImp;
import com.service.ProductDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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

    /**
     * get all the product info
     * @return
     */
    @PostMapping("/detail")
    //get all the product infos
    public Object detail(){
       List<ProductDetail> productDetailList = (List<ProductDetail>) productDetailService.getAllProduct();
        return productDetailList;
    }

    /**
     * redirect to detail page
     * @return
     */
    @GetMapping("/detail")
    public String detail1(){
        return "detail";
    }
}
