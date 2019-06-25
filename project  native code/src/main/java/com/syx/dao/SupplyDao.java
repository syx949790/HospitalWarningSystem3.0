package com.syx.dao;

import com.syx.idao.ISupplyDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SupplyDao implements ISupplyDao {
    @Autowired
    SqlSessionFactory sqlSessionFactory;
    @Override
    public List<Map<String, Object>> findAllSupply(Map map) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String sql = "com.syx.mapper.supplyMapper.findAllSupply";
        List<Map<String,Object>> list = sqlSession.selectList(sql,map);
        return list;
    }

    @Override
    public int findAllCount() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String sql = "com.syx.mapper.supplyMapper.findAllCount";
        int flag= sqlSession.selectOne(sql);
        return flag;
    }

    @Override
    public int deleteSupplyById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String sql = "com.syx.mapper.supplyMapper.deleteSupplyById";
        int flag= sqlSession.delete(sql,id);
        return flag;
    }

    @Override
    public int updateSupplyById(Map map) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String sql = "com.syx.mapper.supplyMapper.updateSupplyById";
        int flag= sqlSession.update(sql,map);
        return flag;
    }

    @Override
    public int insertSupply(Map map) {

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String sql = "com.syx.mapper.supplyMapper.insertSupply";
        int flag= sqlSession.insert(sql,map);
        return flag;
    }
}
