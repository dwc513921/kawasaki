package com.example.demo01.controller;

import com.example.demo01.pojo.User;
import com.example.demo01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    UserService userservice;

    @RequestMapping("showInfos")
    @ResponseBody
    public Map<String,Object> InfoAll(@RequestParam int page,@RequestParam int limit){
        int pages=page-1;
        List<User> list=userservice.InfoAll(pages,limit);
        Map<String,Object> map=new HashMap<>();
        map.put("code" , 0);
        map.put("mas" ,"");
        map.put("count",userservice.count());
        map.put("data",list);
        return map;
    }

    @RequestMapping("getUserInfoByName")
    @ResponseBody
    public Map<String,Object> getInfoByName(@RequestParam(value = "id") String username,@RequestParam int page,@RequestParam int limit){
        int pages=page-1;
        List<User> list=userservice.getInfoByName(username,pages,limit);
        Map<String,Object> map=new HashMap<>();
        map.put("code" , 0);
        map.put("mas" ,"");
        map.put("count",userservice.count());
        map.put("data",list);
        return map;
    }
}
