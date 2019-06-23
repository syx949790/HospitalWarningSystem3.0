package com.syx.service;

import com.syx.dao.SupplyDao;
import com.syx.idao.ISupplyDao;
import com.syx.iservice.IEquipService;
import com.syx.iservice.ISupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class SupplyService implements ISupplyService {
    @Autowired
    SupplyDao supplyDao;
    @Override
    public List<Map<String, Object>> findAllSupply(Map map) {

        List<Map<String,Object>> list = supplyDao.findAllSupply(map);
        return list;
    }

    @Override
    public int findAllCount() {
       int flag = supplyDao.findAllCount();
        return flag;
    }
}
