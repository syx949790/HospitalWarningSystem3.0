package com.syx.iservice;

import java.util.List;
import java.util.Map;

public interface ILogService {
    List<Map<String, Object>> findAllDevice(Map map);
    int findCountDevice();
}
