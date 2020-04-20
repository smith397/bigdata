package com.zj.data.service.serviceimp;

import com.zj.data.domin.FuntureData;
import com.zj.data.domin.RealData;
import com.zj.data.mapper.dataCYDEmapper;
import com.zj.data.util.DateTools;
import com.zj.data.util.ExcelReader;
import com.zj.data.util.SpringContextUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.core.env.Environment;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class dataCUDE {

    @Autowired
    dataCYDEmapper mapper;

    @Autowired
    private Environment env;

    public void insertintodataReal(RealData realData)
    {
        realData.setDate(DateTools.getCurrHourTime(new Date()));
        realData.setWeek(DateTools.dateToWeek(new Date()));
        log.error("插入一条消息");
        System.out.println(realData);
        setDescription.setdescription1(realData, realData.getAccess_jam());
        mapper.insertintodatabaseRealData(realData);
    }

    public void insertintodatabaseFuntureData()
    {
        String property = env.getProperty("file.path1");
        List<FuntureData> funtureDataList = ExcelReader.readExcel(property);
        String substring = property.substring(property.lastIndexOf("\\") + 1);
        String filename = substring.substring(0,substring.lastIndexOf("."));
        for (FuntureData funtureData : funtureDataList) {
            funtureData.setSampleName("监测点3");
            funtureData.setPosition("116.457086,39.914223");
        }
        mapper.insertintodatabaseFuntureData(funtureDataList);
    }

    public List<RealData> SelectByRealData(String StreetName)
    {
        return mapper.SelectByRealData(StreetName);
    }

    public Integer SelectByFuntureDataTotalCount()
    {
        return mapper.SelectByFuntureDataTotalCount();
    }
    public Integer SelectByRealDataTotalCount()
    {
        return mapper.SelectByRealDataTotalCount();
    }

    public List<FuntureData> SelectByFuntureData(String Sample)
    {
        return mapper.SelectByFuntureData(Sample);
    }

}
