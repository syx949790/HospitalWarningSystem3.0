package com.syx.service;

import com.syx.dao.DeviceDao;
import com.syx.iservice.IDeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DeviceService implements IDeviceService {
    @Autowired
    DeviceDao deviceDao;

    @Override
    public List<Map<String, Object>> findAllDevice(Map map) {
        List<Map<String,Object>> list = deviceDao.findAllDevice(map);
        return list;

    }

    @Override
    public int findCountDevice() {
        int flag = deviceDao.findCountDevice();
        return flag;
    }
}
