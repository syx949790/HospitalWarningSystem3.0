package com.syx.iservice;

import java.util.List;
import java.util.Map;

public interface IUserService {
    List<Map<String, Object>> login(String uname, String upwd);

    List<Map<String, Object>> UserList();

    int UserCount();
    int deleteUserById(String id);

    List<Map<String, Object>> findAllUser(Map map);

    int register(String uname2, String upwd2);

    int insertUser(Map map);

    List<Map<String, Object>> userGenderAnalysis();
}
