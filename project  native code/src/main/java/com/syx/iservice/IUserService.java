package com.syx.iservice;

import java.util.List;
import java.util.Map;

public interface IUserService {
    List<Map<String,Object>> login(String uname, String upwd);
}
