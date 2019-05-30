package com.syx.idao;

import java.util.List;
import java.util.Map;

public interface IUserDao {
    List<Map<String, Object>> login(String uname, String upwd);

    List<Map<String, Object>> UserList();

    int UserCount();

    List<Map<String, Object>> findAllUser(Map map);


    int register(String uname2, String upwd2);

    int insertUser(Map map);

    int deleteUserById(int id);
}
