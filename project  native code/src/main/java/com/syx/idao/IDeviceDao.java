package com.syx.idao;

import java.util.List;
import java.util.Map;

public interface IDeviceDao {
    List<Map<String, Object>> findAllDevice(Map map);
    int findCountDevice();
}
