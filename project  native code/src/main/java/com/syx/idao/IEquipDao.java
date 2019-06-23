package com.syx.idao;

import java.util.List;
import java.util.Map;

public interface IEquipDao {
    List<Map<String ,Object>> findAllEquip(Map map);
    int findAllCount();
}
