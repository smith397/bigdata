package com.zj.data.service.serviceimp;

import com.zj.data.domin.FuntureData;
import com.zj.data.domin.RealData;
import com.zj.data.mapper.dataCYDEmapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class dataCUDE {

    @Autowired
    dataCYDEmapper mapper;

    public void insertintodatabas(RealData realData)
    { mapper.insertintodatabaseRealData(realData);}

    public void insertintodatabaseFuntureData(FuntureData funtureData)
    {mapper.insertintodatabaseFuntureData(funtureData);}

    public RealData SelectByRealData()
    {return mapper.SelectByRealData();}

    public FuntureData SelectByFuntureData()
    {return mapper.SelectByFuntureData();}

}
