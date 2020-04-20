package com.zj.data.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
public class RealData {

    private Integer id;
    //请求结果
    private String Status;
    //路况语义化描述
    private String description;
    //拥堵评价
    private String access_jam;
    //时间
    private String date;
//    周几
    private String week;
//    城市
    private String city;
//    道路
    private String street;

    public RealData (Integer id, String status, String description, String access_jam, String date, String week, String city, String street) {
        this.id = id;
        Status = status;
        this.description = description;
        this.access_jam = access_jam;
        this.date = date;
        this.week = week;
        this.city = city;
        this.street = street;
    }
}
