package com.example.his.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class userFee {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private Date date;
    private float rechargeMoney;
    private float money;
    private String vipId;
    private String userName;
    private Integer status;
}
