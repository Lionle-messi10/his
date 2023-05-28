package com.example.his.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.his.entity.userFee;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface userFeeMapper extends BaseMapper<userFee> {
    @Update("update user_fee set money=money + #{rechargeMoney} where vip_id=#{vipId}")
    int increase(@Param("vipId") String vipId, @Param("rechargeMoney")float rechargeMoney);
    @Update("update user_fee set money=money - #{price}*#{num}  where vip_id=#{vipId}")
    int delete(@Param("vipId") String vipId, @Param("price")float price,@Param("num")int num);
    @Insert("insert into issue(vip_id,prescription,num) values(#{vipId},#{prescription},#{num} )")
    int save(@Param("vipId") String vipId, @Param("prescription")String prescription,@Param("num")int num);

}




