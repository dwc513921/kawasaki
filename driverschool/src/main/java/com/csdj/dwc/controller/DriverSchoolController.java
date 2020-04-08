package com.csdj.dwc.controller;

import com.csdj.dwc.pojo.CityArea;
import com.csdj.dwc.pojo.DriverSchool;
import com.csdj.dwc.service.DriverSchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("school")
public class DriverSchoolController {

    @Autowired
    private DriverSchoolService service;

    @RequestMapping("showInfos")
    @ResponseBody
    public Map<String,Object> getAllInfo(@RequestParam Integer page, @RequestParam Integer limit){
        int pages=page-1;
        List<DriverSchool> driverSchools=service.getAllInfo(pages,limit);
        Map<String,Object> map = new HashMap<>();
        map.put("code" , 0);
        map.put("mas" ,"");
        map.put("count",service.count());
        map.put("data",driverSchools);

        return map;
    }

    @RequestMapping("getDriverInfoById")
    @ResponseBody
    public Map<String,Object> getAllInfo(@RequestParam Integer page, @RequestParam Integer limit,@RequestParam(value = "id") String id){
        int pages=page-1;
        List<DriverSchool> driverSchools=service.getInfoById(pages,limit,id);
        Map<String,Object> map = new HashMap<>();
        map.put("code" , 0);
        map.put("mas" ,"");
        map.put("count",service.count());
        map.put("data",driverSchools);
        return map;
    }

    @RequestMapping("updDriverInfoById")
    public ModelAndView getDriverInfoById(ModelAndView mv,@RequestParam(value = "id") int id){
        DriverSchool driverSchool=service.getDriverInfoById(id);
        List<CityArea> cityAreas=service.cityAreas();
        System.out.println("-------------------->"+driverSchool.getName());
        mv.addObject("driverSchool",driverSchool);
        mv.addObject("cityAreas",cityAreas);
        mv.setViewName("update");
        return mv;
    }

    @PutMapping("updateDriverInfo")
    @ResponseBody
    public String updDriver(DriverSchool driverSchool){
        int count=service.updDriver(driverSchool);
        if(count>0){
            return "修改成功";
        }else {
            return "修改失败";
        }
    }

    @RequestMapping("addDriverInfo")
    @ResponseBody
    public String addInfo(DriverSchool driverSchool){
        int count=service.add(driverSchool);
        if(count>0){
            return "添加成功！";
        }else {
            return "添加失败！";
        }
    }

    @RequestMapping("delDriverInfo")
    @ResponseBody
    public String delInfo(int id){
        int count=service.del(id);
        if (count>0){
            return "删除成功！";
        }else {
            return "删除失败！";
        }
    }
}
