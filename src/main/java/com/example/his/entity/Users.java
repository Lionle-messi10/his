package com.example.his.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Controller;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Users {
    @TableId(type =IdType.AUTO )
    private Integer id;
    private String userName;
    private String password;
    private String role;
    private String realName;
    private String  tel;
    private Integer age;
    private String sex;
    private String address;
    private Date createTime;
    private String editTime;
    private Integer status;
    private String vipId;
}
