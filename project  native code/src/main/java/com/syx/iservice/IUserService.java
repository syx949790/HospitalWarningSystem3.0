package com.syx.iservice;

import java.util.List;
import java.util.Map;

public interface IUserService {
    List<Map<String,Object>> login(String uname, String upwd);
    List<Map<String,Object>> UserList();
    int UserCount();

    List<Map<String,Object>> findAllUser(Map map);

    int insert(String uname2,String upwd2);
}
