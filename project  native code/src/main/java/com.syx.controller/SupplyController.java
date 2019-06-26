package com.syx.controller;

import com.syx.service.SupplyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/supply")
public class SupplyController {
    @Autowired
    SupplyService supplyService;

    @RequestMapping("/findAllSupply.do")
    @ResponseBody
    public Map findAllSupply(String supply_name){

        Map map = new HashMap();
        map.put("supply_name",supply_name);
        List<Map<String,Object>> list = supplyService.findAllSupply(map);
        int count = supplyService.findAllCount();
        map.clear();
        map.put("msg", "");
        map.put("code", 0);
        map.put("data", list);
        map.put("count", count);
        return  map;
    }


    @RequestMapping("/updateSupply.do")
    @ResponseBody
    public String updateSupply(String supply_name,String business_license ,String equip_license){

        Map map = new HashMap();
        map.put("supply_name",supply_name);
        map.put("business_license",business_license);
        map.put("equip_license",equip_license);

        int flag = supplyService.updateSupplyById(map);
        if (flag !=0)
        return  "success";
        else
            return "fails";
    }


    @RequestMapping("/insertSupply.do")

    public void insertSupply(String supply_name,String business_license ,String equip_license){

        Map map = new HashMap();
        map.put("supply_name",supply_name);
        map.put("business_license",business_license);
        map.put("equip_license",equip_license);

        int flag = supplyService.insertSupply(map);

    }
}
