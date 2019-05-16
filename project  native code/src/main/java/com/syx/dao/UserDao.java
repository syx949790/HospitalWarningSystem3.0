package com.syx.dao;

import com.syx.idao.IUserDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserDao implements IUserDao {
    @Autowired
    SqlSessionFactory sqlSessionFactory;
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
}
