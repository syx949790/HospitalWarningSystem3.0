package com.syx.service;

import com.syx.dao.EquipDao;
import com.syx.iservice.IEquipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class EquipService implements IEquipService {
    @Autowired
    EquipDao equipDao;
    @Override
    public List<Map<String, Object>> findAllEquip(Map map) {
        List<Map<String,Object>> list = equipDao.findAllEquip(map);
        return list;
    }

    @Override
    public int findAllCount() {
        int flag= equipDao.findAllCount();
        return flag;
    }

    @Override
    public int deleteDeviceById(int id) {
        int flag= equipDao.deleteDeviceById(id);
        return flag;
    }

    @Override
    public int updateDeviceById(Map map) {
        int flag= equipDao.updateDeviceById(map);
        return flag;
    }

    @Override
    public int insertDevice(Map map) {
        int flag= equipDao.insertDevice(map);
        return flag;
    }
}
