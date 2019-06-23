package com.syx.controller;

import com.syx.service.DeviceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@Scope("prototype")
@RequestMapping("/device")
public class deviceController {

@Autowired
    DeviceService deviceService;

    @RequestMapping(value = "/findAllDevice.do")
    @ResponseBody
    public Map<String, Object> findAllUser(String device_name,String device_checker) {

        System.out.println(device_checker+" "+device_name);

        Map map = new HashMap();
        map.put("device_name", device_name);
        map.put("device_checker",device_checker);



        List<Map<String, Object>> list = deviceService.findAllDevice(map);
        int count = deviceService.findCountDevice();
        map.clear();
        map.put("msg", "");
        map.put("code", 0);
        map.put("data", list);
        map.put("count", count);


        return map;


    }
}
