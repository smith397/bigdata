package com.zj.data.test;


import com.zj.data.config.url;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class test {

    @Autowired
    url l;

    @Test
    public void test()
    {
        System.out.println(l.getAk());
    }

}
