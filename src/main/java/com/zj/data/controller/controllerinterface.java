package com.zj.data.controller;

import com.zj.data.domin.RealData;
import com.zj.data.service.serviceimp.dataCUDE;
import lombok.NoArgsConstructor;
import org.checkerframework.checker.units.qual.A;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.Date;


@Controller
public class controllerinterface {
    @Autowired
    dataCUDE dataCURD;

    @ResponseBody
    @RequestMapping("/interface")
    public String test (@RequestBody RealData realData)
    {

       dataCURD.insertintodataReal(realData);
       return "1";

    }
    @RequestMapping("/controller")
    public ModelAndView test (ModelAndView modelAndView)
    {
        modelAndView.setViewName("index");
        return modelAndView;
    }

    @ResponseBody
    @RequestMapping("/funturedata")
    public String test1 ()
    {
        dataCURD.insertintodatabaseFuntureData();
        return "1";
    }



}
