package com.zj.data.service.serviceimp;

import com.zj.data.domin.FuntureData;
import com.zj.data.domin.RealData;
import com.zj.data.mapper.dataCYDEmapper;
import com.zj.data.util.DateTools;
import com.zj.data.util.ExcelReader;
import com.zj.data.util.SpringContextUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.core.env.Environment;

import java.util.Date;
import java.util.List;

@Service
public class dataCUDE {

    @Autowired
    dataCYDEmapper mapper;

    public void insertintodataReal(RealData realData)
    {
        realData.setDate(new Date());
        realData.setWeek(DateTools.dateToWeek(new Date()));
        mapper.insertintodatabaseRealData(realData);
    }

    public void insertintodatabaseFuntureData(FuntureData funtureData)
    {
        Environment environment = SpringContextUtil.getBean(Environment.class);
        String property = environment.getProperty("file.path");
        List<FuntureData> funtureDataList = ExcelReader.readExcel(property);
        mapper.insertintodatabaseFuntureData(funtureDataList);
    }

    public RealData SelectByRealData()
    {return mapper.SelectByRealData();}

    public FuntureData SelectByFuntureData()
    {return mapper.SelectByFuntureData();}

}
