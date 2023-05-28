package com.example.his.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Registration {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String userName;
    private String department;
    private float fee;
    private String doctorName;
}
