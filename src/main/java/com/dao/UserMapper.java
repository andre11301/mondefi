package com.dao;

import com.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
/**

 *  Dao layer for User(interface)

 * @author andre

 * @Time 2018/10/29

 *

 */
public interface UserMapper {
    //delete record by PrimaryKey
    int deleteByPrimaryKey(Integer id);

    //insert record
    int insert(User record);

    //insert records selective
    int insertSelective(User record);

    //get user  by primarykey
    User selectByPrimaryKey(Integer id);

    //get all the user infos
    List<User> selectAllUser();

    //update by PrimaryKeySelective
    int updateByPrimaryKeySelective(User record);

    //update by PrimaryKey
    int updateByPrimaryKey(User record);

    //get user  by username&password
    User selectByUsernameAndPwd(@Param("username") String username, @Param("password") String password);
}