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

    @Autowired
    private Environment env;

    public void insertintodataReal(RealData realData)
    {
        realData.setDate(new Date());
        realData.setWeek(DateTools.dateToWeek(new Date()));
        mapper.insertintodatabaseRealData(realData);
    }

    public void insertintodatabaseFuntureData()
    {
        String property = env.getProperty("file.path1");
        List<FuntureData> funtureDataList = ExcelReader.readExcel(property);
        String substring = property.substring(property.lastIndexOf("\\") + 1);
        String filename = substring.substring(0,substring.lastIndexOf("."));
        for (FuntureData funtureData : funtureDataList) {
            funtureData.setSampleName(filename);
        }
        mapper.insertintodatabaseFuntureData(funtureDataList);
    }

    public RealData SelectByRealData()
    {return mapper.SelectByRealData();}

    public FuntureData SelectByFuntureData()
    {return mapper.SelectByFuntureData();}

}
