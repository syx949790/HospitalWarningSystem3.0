package com.syx.dao;

import com.syx.idao.IUserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao implements IUserDao {
    @Autowired
    SqlSessionFactory sqlSessionFactory;



    @Override
    public int insert(String uname2,String upwd2,String email,String role) {

        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        String sql="com.syx.mapper.userMapper.insertUserByOne";
        Map map=new HashMap();
        map.put("uname",uname2);
        map.put("upwd",upwd2);
        map.put("email",email);
        map.put("role",role);



        int flag=sqlSession.insert(sql,map);

        return flag;
    }

    @Override
    public List<Map<String, Object>> login(String uname, String upwd) {


        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        String sql="com.syx.mapper.userMapper.findUserByUnameAndUpwd";
        Map map=new HashMap();
        map.put("uname",uname);
        map.put("upwd",upwd);
        List<Map<String,Object>> list=sqlSession.selectList(sql,map);
        System.out.println(list);

        return list;
    }

    @Override
    public List<Map<String, Object>> UserList() {
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        String sql="com.syx.mapper.userMapper.findUserAll";
        List<Map<String ,Object>> list=sqlSession.selectList(sql);
        System.out.println(list.size()+"size");
        return list;
    }

    @Override
    public int UserCount() {
        SqlSession sqlSession=sqlSessionFactory.openSession(true);
        String sql="com.syx.mapper.userMapper.findCountUser";

        int count=sqlSession.selectOne(sql);  /*聚合函数*/

        return count;
    }


}
