package com.example.his.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.his.common.R;
import com.example.his.dao.userFeeMapper;
import com.example.his.entity.userFee;
import com.example.his.service.userFeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class userFeeServiceImpl extends ServiceImpl<userFeeMapper, userFee> implements userFeeService {
    @Autowired
    private userFeeMapper userFeeMapper;

    @Transactional
    public R<String> increase(String vipId, float rechargeMoney){
        userFeeMapper.increase(vipId, rechargeMoney);
        return null;
    }
    @Transactional
    public R<String> delete(String vipId,float price,int num){
        userFeeMapper.delete(vipId,price,num);
        return null;
    }
    @Transactional
    public R<String> save(String vipId,String prescription,int num){
        userFeeMapper.save(vipId,prescription,num);
        return null;
    }
}
