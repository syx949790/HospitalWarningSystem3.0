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
}
