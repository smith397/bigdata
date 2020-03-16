package com.zj.data.test;


import com.zj.data.domin.RealData;
import com.zj.data.mapper.dataCYDEmapper;
import com.zj.data.service.serviceimp.dataCUDE;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@SpringBootTest
@RunWith(SpringRunner.class)
public class test {

    @Autowired
    dataCUDE data;

//    @Test
//    public void test(){
//        System.out.println(data);
//        data.insertintodataReal(new RealData (1, 1, "1", "1", new Date()));
//    }



}
