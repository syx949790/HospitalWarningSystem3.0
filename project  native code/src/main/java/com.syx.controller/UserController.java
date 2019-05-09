package com.syx.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("prototype")
@RequestMapping("/user")

public class UserController {

    @RequestMapping("/show.do")
    @ResponseBody
    public List showTest(){

        System.out.println("showTest() success!");
        List list=new ArrayList();
        list.add("zhangsan");
        list.add("1");
        list.add("2");
        list.add("3");

        return list;
    /*    return "../index.jsp";*/
    }

}
