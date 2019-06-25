package com.syx.idao;

import java.util.List;
import java.util.Map;

public interface ISupplyDao {
    List<Map<String,Object>> findAllSupply(Map map);
    int findAllCount();
    int deleteSupplyById(int id);
    int updateSupplyById(Map map);
    int insertSupply(Map map);
}
