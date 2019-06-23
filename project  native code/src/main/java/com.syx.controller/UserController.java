package com.syx.controller;

import com.syx.service.UserService;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.*;

@Controller
@Scope("prototype")
@RequestMapping("/user")

public class UserController {

    @Resource
    UserService userService;




    @RequestMapping("/updateUser.do")
    @ResponseBody
    public String UpdateUser(String id,String uname,String password,String email,String address,String telephone){
        System.out.println(id+" "+uname+" "+telephone);
        int uid = Integer.parseInt(id);
        Map map = new HashMap();
        map.put("id",uid);
        map.put("uname",uname);
        map.put("password",password);
        map.put("email",email);
        map.put("address",address);
        map.put("telephone",telephone);

        int i = userService.updateUser(map);
        if (i != 0)
            return "success";
        else
            return "fails";

    }
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


    @RequestMapping("/uploadPhoto.do")
    @ResponseBody
    public Map uploadPhoto(MultipartFile file,HttpSession session) throws IOException {


        System.out.println(session.getAttribute("uname"));
        List allowPhotoTypeList =new ArrayList();
        allowPhotoTypeList.add(".jpg");
        allowPhotoTypeList.add(".png");
        allowPhotoTypeList.add(".bmp");
        allowPhotoTypeList.add(".jpeg");
        allowPhotoTypeList.add(".gif");



        Map map=new HashMap();
        String fileName= file.getOriginalFilename();

        String extName =fileName.substring(fileName.lastIndexOf("."));
        String newFileName= new Date().getTime()+extName;
        if (allowPhotoTypeList.contains(extName)){

            //String realPath=session.getServletContext().getRealPath("images");
            String  realPath = "D:\\eclipse\\HospitalWarningSystem1.5.5\\project  native code\\src\\main\\webapp\\images";

            System.out.println(realPath);

            File target=new File(realPath);
            if (!target.exists())
                target.mkdir();

            target=new File(realPath,newFileName);
            file.transferTo(target);



            map.put("uname",session.getAttribute("uname"));

            map.put("photo","images"+'\\'+newFileName);
            userService.updatePhoto(map);
            System.out.println(newFileName);
            map.clear();
            map.put("code",0);
        }else {
            map.put("code",1);
        }






        return map;


    }

    @RequestMapping("/register.do")
    @ResponseBody
    public String register(String uname2, String upwd2) {


        int flag = userService.register(uname2, upwd2);


        if (flag == 1) {
            return "success";
        } else {
            return "fails";
        }

    }

    @RequestMapping("/deleteById.do")
    @ResponseBody
    public String deleteUserById(String id) {
          String [] arr = id.split(",");
          int flag=0;
for (String str:arr){
     flag = userService.deleteUserById(str);
}



        if (flag == 1) {
            return "success";
        } else {
            return "fails";
        }

    }

    @RequestMapping("/insertUser.do")
    @ResponseBody
    public String insertUser(String uname, String upwd, String runame, String address,String role) {

        Map map = new HashMap();
        map.put("uname", uname);
        map.put("upwd", upwd);
        map.put("address", address);
        map.put("runame", runame);
        map.put("role", role);

        int flag = userService.insertUser(map);
        System.out.println("insertUser  success!" );

        if (flag == 1) {
            return "success";
        } else {
            return "fails";
        }

    }


    @RequestMapping(value = "/login.do", method = RequestMethod.POST)
    @ResponseBody
    public String login(@RequestParam("uname") String uname, String upwd, HttpSession session) {

        List<Map<String, Object>> list = userService.login(uname, upwd);
        if (list.size() > 0){
             session.setAttribute("uname",uname);



            return "success";
        }

        else
            return "fails";

    }





    @RequestMapping(value = "/findAllUser.do")
    @ResponseBody
    public Map<String, Object> findAllUser(String uname, int page, int limit) {



        Map map = new HashMap();
        map.put("uname", uname);
        map.put("recordIndex", (page - 1) * limit);
        map.put("pagesize", limit);


        List<Map<String, Object>> list = userService.findAllUser(map);
        int count = userService.UserCount();
        map.clear();
        map.put("msg", "");
        map.put("code", 0);
        map.put("data", list);
        map.put("count", count);


        return map;


    }



    @RequestMapping(value = "/findUserByUname.do")
    @ResponseBody
    public Map<String, Object> findUserByUname( String  page, String limit,HttpSession session) {


       int p= Integer.parseInt(page);
       int l = Integer.parseInt(limit);

        System.out.println(session.getAttribute("uname") +" "+p+ " " + l);
        Map map = new HashMap();
        map.put("uname", session.getAttribute("uname"));
        map.put("recordIndex", (p - 1) * l);
        map.put("pagesize", l);


        List<Map<String, Object>> list = userService.findAllUser(map);

        Map map1 = new HashMap();
        map1 = list.get(0);
        map.clear();

        map.put("uname",map1.get("uname"));
        map.put("photo",map1.get("photo"));





        return map;


    }



    /*
     * 返回用户列表方法，因为layui需要的json数据格式，所以参照json格式返回对应的集合对象
     *
     * */

    @RequestMapping(value = "/userlist.do")
    @ResponseBody
    public Map<String, Object> UserList() {

        //先获取userlist列表对象
        List<Map<String, Object>> list = userService.UserList();
        System.out.println(list.size());
        if (list.size() > 0) {

            int count = userService.UserCount();

            Map<String, Object> map = new HashMap<>();
            map.put("msg", "");
            map.put("code", 0);
            map.put("data", list);
            map.put("count", count);
            return map;
        } else {

            return null;
        }


    }

    @RequestMapping(value = "/userGenderAnalysis.do")
    @ResponseBody
    public Map<String, Object> userGenderAnalysis() {

        //先获取userlist列表对象
        List<Map<String, Object>> list = userService.userGenderAnalysis();

        List<Object> list1=new ArrayList();
        List<Object> list2 = new ArrayList();
        for (Map map1:list){
            list1.add( map1.get("gender"));
            list2.add( map1.get("count"));
        }

       Map map=new HashMap();
       map.put("gender",list1);
       map.put("count",list2);


       return map;


    }


    @RequestMapping(value = "/manPercent.do")
    @ResponseBody
    public double manPercent() {

        //先获取userlist列表对象
        List<Map<String, Object>> list = userService.userGenderAnalysis();
        int count=0;
        int man=0;
        for (Map map1:list){
            if(map1.get("gender").toString().equals("男")){
                man=Integer.parseInt(map1.get("count").toString());
            }
            count+=Integer.parseInt(map1.get("count").toString());
        }


        return (double)man/count;


    }


}
