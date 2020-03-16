package com.zj.data.mapper;

import com.zj.data.domin.FuntureData;
import com.zj.data.domin.RealData;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

@Repository
public interface dataCYDEmapper {

   public void insertintodatabaseRealData(RealData realData);

   public void insertintodatabaseFuntureData(FuntureData funtureData);

   public RealData SelectByRealData();

   public FuntureData SelectByFuntureData();

   public Integer SelectByRealDataTotalCount();

}
