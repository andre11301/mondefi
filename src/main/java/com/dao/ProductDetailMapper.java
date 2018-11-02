package com.dao;

import com.domain.ProductDetail;
import com.domain.User;

import java.util.List;
/**

 *  Dao layer for productDetail(interface)

 * @author andre

 * @Time 2018/10/29

 *

 */
public interface ProductDetailMapper {
    //delete record by PrimaryKey
    int deleteByPrimaryKey(Integer id);

    //insert record
    int insert(ProductDetail record);

    //insert records selective
    int insertSelective(ProductDetail record);

    //get all the product infos
    List<ProductDetail> selectAllProduct();

    //get product info by primarykey
    ProductDetail selectByPrimaryKey(Integer id);

    //update by PrimaryKeySelective
    int updateByPrimaryKeySelective(ProductDetail record);

    //update PrimaryKeySelective
    int updateByPrimaryKey(ProductDetail record);
}