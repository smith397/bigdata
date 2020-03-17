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
    private Integer Status;
    //路况语义化描述
    private String description;
    //拥堵评价
    private String access_jam;
    //时间
    private Date date;
//    周几
    private String week;

    public RealData (Integer id, Integer status, String description, String access_jam, Date date, String week) {
        this.id = id;
        Status = status;
        this.description = description;
        this.access_jam = access_jam;
        this.date = date;
        this.week = week;
    }
}
