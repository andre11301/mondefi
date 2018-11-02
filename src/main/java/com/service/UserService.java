package com.service;

import com.domain.User;

import java.util.List;

/**

 *  Service layer : UserService interface

 * @author andre

 * @Time 2018/10/28

 *

 */
public interface UserService {
     List<User> getUser();
     int updateUser(User user);
     User getUserByid(Integer id);
     User getUserByUserNameAndPwd(String username, String pwd);

}
