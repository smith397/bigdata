package com.zj.data.service.serviceimp;

import com.zj.data.domin.FuntureData;
import com.zj.data.domin.RealData;
import com.zj.data.mapper.dataCYDEmapper;
import com.zj.data.util.DateTools;
import lombok.extern.slf4j.Slf4j;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Slf4j
@Service
public class CompareService {

    @Autowired
    dataCUDE data;
    @Autowired
    dataCYDEmapper dataCYDEmapper;

//  进行每个监测点的比较
    public void Compare(String Sample)
    {
        String StreetName = mapperSwitch.map(Sample);
        if (Sample.equals("error")) log.error("没有该监测点");
        List<RealData> Temp = new ArrayList<>();
        List<FuntureData> funtureDataList = data.SelectByFuntureData(Sample);
        for (FuntureData funtureData : funtureDataList) {
            String week = funtureData.getWeek();
            String date = funtureData.getDate();
            List<RealData> realdata = dataCYDEmapper.SelectByData(week,StreetName);
            Temp.clear();//清空
            for (RealData realdatum : realdata) {
                if (date.equals(DateTools.dateToTime(realdatum.getDate())))
                {
                    Temp.add(realdatum);
                }
            }
            Analysis(Temp,funtureData);
        }

    }

//将进行匹配之后的数据进行对比分析
  public void Analysis (List<RealData> realdata,FuntureData funtureData)
  {
      String statusFunture = funtureData.getStatus();
      Double TotalCount = (double) realdata.size();
      if (TotalCount==0)
          return;
//      用来计数用
      Double Count = (double)0;
      for (RealData realdatum : realdata) {
          String statusReal = realdatum.getAccess_jam();
          if (statusFunture.equals(statusReal))
              Count++;
      }
      System.out.println(Count);
      System.out.println(TotalCount);
      Double Rate = Count/TotalCount*100;
      String PercentRate = Rate.toString()+"%";
      System.out.println(PercentRate);
  }

}
