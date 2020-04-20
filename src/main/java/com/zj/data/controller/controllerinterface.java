package com.zj.data.controller;

import com.zj.data.domin.RealData;
import com.zj.data.service.serviceimp.AsyncService;
import com.zj.data.service.serviceimp.CompareService;
import com.zj.data.service.serviceimp.dataCUDE;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;
import java.util.List;
import java.util.concurrent.*;


@Controller
public class controllerinterface {
    @Autowired
    dataCUDE dataCURD;
    @Autowired
    CompareService compareService;

    @Autowired
    private AsyncService asyncService;

    @ResponseBody
    @RequestMapping("/interface")
    public String test(@RequestBody RealData realData) {
        dataCURD.insertintodataReal(realData);
        return "1";

    }

    @RequestMapping("/controller")
    public ModelAndView test(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/funturedata")
    public String test1() {
        compareService.Compare("aa");
//        System.out.println(realData);
        return "1";
    }


    @ResponseBody
    @RequestMapping("/compare")
    public String compare() {
        compareService.Compare("监测点2");
        return "success";
    }

    @ResponseBody
    @RequestMapping("/thread")
    public String thread() {
        //调用service层的任务
        asyncService.executeAsync();
        return "success4324324";
    }
}



