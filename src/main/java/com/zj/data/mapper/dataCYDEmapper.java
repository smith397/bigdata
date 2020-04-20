package com.zj.data.mapper;

import com.zj.data.domin.FuntureData;
import com.zj.data.domin.RealData;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Repository
public interface dataCYDEmapper {

   public void insertintodatabaseRealData(RealData realData);

   public void insertintodatabaseFuntureData(List<FuntureData> funtureData);

   public List<RealData> SelectByRealData(@Param("StreetName") String StreetName);

   public List<FuntureData> SelectByFuntureData(@Param("Sample") String Sample);

   public Integer SelectByRealDataTotalCount();

   public Integer SelectByFuntureDataTotalCount();

   public List<RealData> SelectByData(@Param("week") String week,@Param("StreetName") String StreetName);


}
