package com.syx.service;

import com.syx.dao.LogDao;
import com.syx.iservice.ILogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LogService implements ILogService {
    @Autowired
    LogDao logDao;

    @Override
    public List<Map<String, Object>> findAllDevice(Map map) {
        List<Map<String,Object>> list = logDao.findAllDevice(map);
        return list;

    }

    @Override
    public int findCountDevice() {
        int flag = logDao.findCountDevice();
        return flag;
    }
}
