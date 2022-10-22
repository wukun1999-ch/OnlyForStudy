package com.qian.dao;

import com.qian.pojo.User;

import java.util.List;
import java.util.Map;

public interface UserMapper {
//    查询获取全部用户
    List<User> getUserList();

//    根据ID查询全部用户
    User getUserById(int id);
    //    根据ID查询全部用户
    User getUserById_Map(Map<String,Object> map);

    //    insert增加一个用户，使用map不需要知道数据库里有什么
    int addUser_Map(Map<String,Object> map);

//    insert增加一个用户
    int addUser(User user);

//    修改用户
    int updateUser(User user);
//    删除用户
    int deleteUser(int id);
}
