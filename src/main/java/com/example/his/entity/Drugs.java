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
public class Drugs {
        @TableId(type = IdType.AUTO)
        private Integer id;
        private String prescription;
        private float price;
        private float purchasePrice;
        private Integer num;
        private Date introduceDate;
        private Date productDate;
        private String qualityPeriod;
        private String supplyUnit;
        private String productUnit;
}
