package com.syx.idao;

import java.util.List;
import java.util.Map;

public interface ISupplyDao {
    List<Map<String,Object>> findAllSupply(Map map);
    int findAllCount();
}
