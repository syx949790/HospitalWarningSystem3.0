package com.syx.controller;

import com.syx.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/user")

public class UserController {

    @Resource
    UserService userService;
    @RequestMapping("/show.do")
    @ResponseBody
    public List showTest() {

        System.out.println("showTest() success!");
        List list = new ArrayList();
        list.add("zhangsan");
        list.add("1");
        list.add("2");
        list.add("3");

        return list;
        /*    return "../index.jsp";*/
    }
    @RequestMapping("/insert.do")
    @ResponseBody
    public  String insert(String uname2,String upwd2){


      int flag=userService.insert(uname2,upwd2);


        if (flag==1){
            return "success";
        }
        else {
            return "fails";
        }

    }

    @RequestMapping(value = "/login.do",method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestParam("uname") String uname,String upwd ) {

        List<Map<String,Object>> list=userService.login(uname,upwd);
        if(list.size()>0)
            return "success";
        else
            return "falis";

    }



    @RequestMapping(value = "/findAllUser.do")
    @ResponseBody
    public Map<String,Object> findAllUser( String uname,int page,int limit ) {

        Map map=new HashMap();
        map.put("uname",uname);
        map.put("recordIndex",(page-1)*limit);
        map.put("pagesize",limit);



        List<Map<String,Object>> list=userService.findAllUser(map);
        int count=userService.UserCount();
        map.clear();
        map.put("msg","");
        map.put("code",0);
        map.put("data",list);
        map.put("count",count);


        return map;


    }







    /*
    * 返回用户列表方法，因为layui需要的json数据格式，所以参照json格式返回对应的集合对象
    *
    * */

    @RequestMapping(value = "/userlist.do")
    @ResponseBody
    public Map<String,Object> UserList( ) {

        //先获取userlist列表对象
        List<Map<String,Object>> list=userService.UserList();
        System.out.println(list.size());
        if(list.size()>0){

            int count=userService.UserCount();

            Map<String,Object> map=new HashMap<>();
            map.put("msg","");
            map.put("code",0);
            map.put("data",list);
            map.put("count",count);
            return map;
        }


        else{

            return null;
        }


    }




}
