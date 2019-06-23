package com.syx.iservice;

import java.util.List;
import java.util.Map;

public interface IEquipService {
    List<Map<String ,Object>> findAllEquip(Map map);
    int findAllCount();
}
