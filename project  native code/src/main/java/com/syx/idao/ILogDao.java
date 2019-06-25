package com.syx.idao;

import java.util.List;
import java.util.Map;

public interface ILogDao {
    List<Map<String, Object>> findAllDevice(Map map);
    int findCountDevice();
}
