package com.syx.dao;

import com.syx.idao.IEquipDao;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class EquipDao implements IEquipDao {
    @Autowired
    SqlSessionFactory sqlSessionFactory;

    @Override
    public List<Map<String, Object>> findAllEquip(Map map) {

        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String sql = "com.syx.mapper.equipMapper.findAllEquip";


        List<Map<String,Object>> list = sqlSession.selectList(sql,map);

        System.out.println(list);

        return list;
    }

    @Override
    public int findAllCount() {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String sql = "com.syx.mapper.equipMapper.findAllCount";
        int flag = sqlSession.selectOne(sql);
        return flag;
    }

    @Override
    public int deleteDeviceById(int id) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String sql = "com.syx.mapper.equipMapper.deleteDeviceById";
        int flag = sqlSession.delete(sql,id);
        System.out.println("deleteDeviceById"+flag);
        return flag;
    }

    @Override
    public int updateDeviceById(Map map) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String sql = "com.syx.mapper.equipMapper.updateDeviceById";
        int flag = sqlSession.update(sql,map);
        System.out.println("updateDeviceById"+flag);
        return flag;

    }

    @Override
    public int insertDevice(Map map) {
        SqlSession sqlSession = sqlSessionFactory.openSession(true);
        String sql = "com.syx.mapper.equipMapper.insertDevice";
        int flag = sqlSession.insert(sql,map);
        System.out.println("insertDeviceById"+flag);
        return flag;
    }
}
