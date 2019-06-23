package com.syx.iservice;

import java.util.List;
import java.util.Map;

public interface ISupplyService {
    List<Map<String,Object>> findAllSupply(Map map);
    int findAllCount();
}
