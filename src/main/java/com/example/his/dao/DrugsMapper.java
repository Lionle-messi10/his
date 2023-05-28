package com.example.his.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.his.common.R;
import com.example.his.entity.Drugs;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface DrugsMapper extends BaseMapper<Drugs> {
    @Update("update drugs set num=num - #{num} where prescription=#{prescription}")
    int increase(@Param("prescription")String prescription,@Param("num")int num);
}
