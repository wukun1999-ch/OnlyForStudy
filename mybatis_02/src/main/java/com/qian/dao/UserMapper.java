package com.qian.dao;

import com.qian.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
//    查询获取全部用户
    List<User> getUserList();

//    根据ID查询全部用户
    User getUserById(int id);
//    insert增加一个用户
    int addUser(User user);

//    修改用户
    int updateUser(User user);
//    删除用户
    int deleteUser(int id);
}
