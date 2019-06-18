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
    public int register(String uname2, String upwd2) {

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String sql = "com.syx.mapper.userMapper.register";
        Map map = new HashMap();
        map.put("uname", uname2);
        map.put("upwd", upwd2);


        System.out.println("register fail");
        int flag = sqlSession.insert(sql, map);
        System.out.println("register success");
        return flag;
    }

    @Override
    public int insertUser(Map map) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String sql = "com.syx.mapper.userMapper.insertUser";


        System.out.println(" insertUser fail");
        int flag = sqlSession.insert(sql, map);


        String sql1 = "com.syx.mapper.userMapper.insertUserInfo";
        int flag1=sqlSession.insert(sql1,map);

        return flag;

    }

    @Override
    public int deleteUserById(String id) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String sql = "com.syx.mapper.userMapper.deleteById";
        int flag = sqlSession.delete(sql,id);
        return flag;
    }

    @Override
    public List<Map<String, Object>> userGenderAnalysis() {

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String sql = "com.syx.mapper.userMapper.userGenderAnalysis";
        List<Map<String, Object>> list = sqlSession.selectList(sql);

        return list;

    }

    @Override
    public int updatePhoto(Map map) {

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String sql = "com.syx.mapper.userMapper.updatePhoto";

        int i = sqlSession.update(sql,map);
        System.out.println(i);
        return i;
    }

    @Override
    public List<Map<String, Object>> login(String uname, String upwd) {


        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String sql = "com.syx.mapper.userMapper.findUserByUnameAndUpwd";
        Map map = new HashMap();
        map.put("uname", uname);
        map.put("upwd", upwd);
        List<Map<String, Object>> list = sqlSession.selectList(sql, map);
        System.out.println(list);

        return list;
    }

    @Override
    public List<Map<String, Object>> UserList() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String sql = "com.syx.mapper.userMapper.findUserAll";
        System.out.println("userlist" + "size");
        List<Map<String, Object>> list = sqlSession.selectList(sql);
        System.out.println("userlist"+list.size() + "size");
        return list;
    }

    @Override
    public int UserCount() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String sql = "com.syx.mapper.userMapper.findCountUser";

        int count = sqlSession.selectOne(sql);  /*聚合函数*/

        return count;
    }

    @Override
    public List<Map<String, Object>> findAllUser(Map map) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String sql = "com.syx.mapper.userMapper.findAllUser";
        System.out.println("findAllUser  fail！");
        List<Map<String, Object>> list = sqlSession.selectList(sql, map);
        System.out.println("findAllUser  success！");
        return list;
    }


}
