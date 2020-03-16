package com.zj.data.controller;

import com.zj.data.domin.RealData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;

@Controller
public class controllerinterface {

    @ResponseBody
    @RequestMapping("/interface")
    public String test (@RequestBody RealData realData)
    {
        realData.setDate(new Date());

        return "success";
    }




}
