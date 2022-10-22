package com.qian.dao;

import com.qian.pojo.User;
import com.qian.utils.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserMapperTest {
    @Test
    public void test(){
//        第一步获取sqlsession对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        try{//        方式一 直接getmapper
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            List<User> userList = mapper.getUserList();


//        遍历数组
            for(User user:userList){
                System.out.println(user);
            }}
        catch (Exception e){}
        finally {
            //关闭sqlsession
            sqlSession.close();
        }
    }
    @Test
    public void getUserById(){
//        获取sql执行对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper =sqlSession.getMapper(UserMapper.class);
        User user = mapper.getUserById(1);
        System.out.println(user);

        sqlSession.close();
    }
    public void getUserById_Map(){
//        获取sql执行对象
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper =sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userId",1);
        mapper.getUserById_Map(map);

        sqlSession.close();
    }
    //增删改需要提交事务！
    @Test
    public void addUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper =sqlSession.getMapper(UserMapper.class);
        mapper.addUser(new User(5,"张","123456"));

        sqlSession.commit();
//提交事务
        sqlSession.close();
    }
    @Test
    public void addUser_Map(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper =sqlSession.getMapper(UserMapper.class);
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("userId",5);
        map.put("userName","李");
        map.put("userPwd","123456");

        mapper.addUser_Map(map);
        sqlSession.commit();
//提交事务
        sqlSession.close();
    }
    //改数据
    @Test
    public void updateUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper =sqlSession.getMapper(UserMapper.class);
        mapper.updateUser(new User(4,"zhang","1234567"));

        sqlSession.commit();
//提交事务
        sqlSession.close();
    }
    @Test
    public void deleteUser(){
        SqlSession sqlSession = MybatisUtils.getSqlSession();
        UserMapper mapper =sqlSession.getMapper(UserMapper.class);
        mapper.deleteUser(5);

        sqlSession.commit();
//提交事务
        sqlSession.close();
    }
}
