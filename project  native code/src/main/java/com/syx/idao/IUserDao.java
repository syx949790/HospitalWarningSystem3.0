package com.syx.idao;

import java.util.List;
import java.util.Map;

public interface IUserDao {
    List<Map<String,Object>> login(String uname,String upwd);
    List<Map<String,Object>> UserList();
    int UserCount();


    int insert(String uname2,String upwd2,String email,String role);
}
