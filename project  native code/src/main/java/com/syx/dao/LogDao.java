package com.syx.dao;

import com.syx.idao.ILogDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class LogDao implements ILogDao {
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Override
    public List<Map<String, Object>> findAllDevice(Map map) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String sql = "com.syx.mapper.logMapper.findAllDevice";
        List<Map<String,Object>> list=sqlSession.selectList(sql,map);
        System.out.println(list);
        return list;
    }

    @Override
    public int findCountDevice() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String sql = "com.syx.mapper.logMapper.findCountDevice";
        int flag = sqlSession.selectOne(sql);
        System.out.println(flag);
        return flag;
    }
}
