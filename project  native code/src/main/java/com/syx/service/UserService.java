package com.syx.service;

import com.syx.dao.UserDao;
import com.syx.iservice.IUserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class UserService implements IUserService {
    @Resource
    UserDao userDao;

    @Override
    public List<Map<String, Object>> login(String uname, String upwd) {
        List<Map<String, Object>> list = userDao.login(uname, upwd);

        return list;
    }

    @Override
    public List<Map<String, Object>> UserList() {
        List<Map<String, Object>> list = userDao.UserList();
        return list;
    }

    @Override
    public int UserCount() {
        int count = userDao.UserCount();
        return count;
    }

    @Override
    public int deleteUserById(String id) {
        int flag = userDao.deleteUserById(id);
        return flag;
    }

    @Override
    public List<Map<String, Object>> findAllUser(Map map) {
        List<Map<String, Object>> list = userDao.findAllUser(map);
        return list;
    }

    @Override
    public int register(String uname2, String upwd2) {

        int flag = userDao.register(uname2, upwd2);

        return flag;
    }

    @Override
    public int insertUser(Map map) {
        int flag = userDao.insertUser(map);

        return flag;
    }
}
