package com.example.his.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Diagnosis {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String vipId;
    private String userName;
    private String overcome;
    private String prescription;
    private Integer num;
}
