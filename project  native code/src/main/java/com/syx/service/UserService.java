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
       List<Map<String,Object>> list = userDao.login(uname,upwd);
        //System.out.println(uname+","+upwd);
        return list;
    }
}
