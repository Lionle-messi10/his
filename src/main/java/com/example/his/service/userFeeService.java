package com.example.his.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.his.common.R;
import com.example.his.entity.userFee;

public interface userFeeService extends IService<userFee> {
    R<String> increase(String vipId , float rechargeMoney);
    R<String> delete(String vipId , float price,int num);
    R<String> save(String vipId , String prescription,int num);
}
