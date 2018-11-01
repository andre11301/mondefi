package com.service;

import com.domain.User;

import java.util.List;

public interface UserService {
     List<User> getUser();
     int updateUser(User user);
     User getUserByid(Integer id);
     User getUserByUserNameAndPwd(String username, String pwd);

}
