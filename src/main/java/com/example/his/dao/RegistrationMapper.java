package com.example.his.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.his.entity.Registration;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface RegistrationMapper extends BaseMapper<Registration> {
}


