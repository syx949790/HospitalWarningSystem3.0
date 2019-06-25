package com.syx.controller;

import com.syx.service.EquipService;
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
@RequestMapping("/equip")
public class EquipController {
     @Autowired
    EquipService equipService;

     @RequestMapping("/findAllEquip.do")
     @ResponseBody
     public Map findAllEquip(String medicine_department, String t_device_name){

         System.out.println(medicine_department+" "+t_device_name);
         Map map = new HashMap();
         map.put("medicine_department",medicine_department);
         map.put("t_device_name",t_device_name);
         List<Map<String,Object>> list = equipService.findAllEquip(map);
         int count = equipService.findAllCount();
         map.clear();
         map.put("msg", "");
         map.put("code", 0);
         map.put("data", list);
         map.put("count", count);


         return map;
     }


    @RequestMapping("/updateDevice.do")
    @ResponseBody
    public String updateDevice(String t_check_date, String t_left_day,String warning_day,int id){

        System.out.println("更新设备"+t_check_date+" "+t_left_day+" "+warning_day+" "+id);
        Map map = new HashMap();
        map.put("t_check_date",t_check_date);
        map.put("t_left_day",t_left_day);
        map.put("warning_day",warning_day);
        map.put("id",id);
        int flag = equipService.updateDeviceById(map);


        if (flag !=0)
            return "success";
        else
            return "fails";
    }

    @RequestMapping("/deleteDevice.do")
    @ResponseBody
    public String deleteDevice(int id){


        System.out.println("deleteDevice  id="+ id);
        int flag = equipService.deleteDeviceById(id);


        if (flag !=0)
            return "success";
        else
            return "fails";
    }

    @RequestMapping("/insertDevice.do")
    @ResponseBody
    public void insertDevice(String medicine_department,String t_device_name,String t_buy_date,String t_check_circle){


        System.out.println("添加设备"+t_device_name+" "+t_buy_date+" "+t_check_circle+" "+medicine_department);
        Map map = new HashMap();
        map.put("t_device_name",t_device_name);
        map.put("t_buy_date",t_buy_date);
        map.put("t_check_circle",t_check_circle);
        map.put("medicine_department",medicine_department);
        int flag = equipService.insertDevice(map);



    }
}
