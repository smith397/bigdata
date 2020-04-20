package com.zj.data.service.serviceimp;

import com.zj.data.Enum.Status;
import com.zj.data.domin.FuntureData;
import com.zj.data.domin.RealData;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class setDescription {

    public static void setdescription(FuntureData funtureData,String status)
    {
        switch (status){
            case "1":
                funtureData.setDescription(Status.changtong.getStatus());
                break;
            case "3":
                funtureData.setDescription(Status.yongdu.getStatus());
                break;
            case "2":
                funtureData.setDescription(Status.huanxing.getStatus());
                break;
            case "4":
                funtureData.setDescription(Status.yanzhongyongdu.getStatus());
                break;
            default:
                log.info("收到其他类型确认报文");
        }
    }
    public static void setdescription1(RealData realData, String status)
    {
        switch (status){
            case "1":
                realData.setDescription(Status.changtong.getStatus());
                break;
            case "3":
                realData.setDescription(Status.yongdu.getStatus());
                break;
            case "2":
                realData.setDescription(Status.huanxing.getStatus());
                break;
            case "4":
                realData.setDescription(Status.yanzhongyongdu.getStatus());
                break;
            default:
                log.info("收到其他类型确认报文");
        }
    }
}
