package com.domain;

import java.io.Serializable;

/**

 *  Bean class productDetail

 * @author andre

 * @Time 2018/10/29

 *

 */
public class ProductDetail implements Serializable {
    private Integer id;

    private String productname;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getProductname() {
        return productname;
    }

    public void setProductname(String productname) {
        this.productname = productname == null ? null : productname.trim();
    }
}