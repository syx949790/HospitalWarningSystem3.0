package com.syx.iservice;

import java.util.List;
import java.util.Map;

public interface IDeviceService {
    List<Map<String, Object>> findAllDevice(Map map);
    int findCountDevice();
}
