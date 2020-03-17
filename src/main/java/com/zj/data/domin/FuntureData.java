package com.zj.data.domin;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuntureData {
    private Integer id;
    private String week;
    private String Status;
    private String date;
}
