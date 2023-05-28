package com.example.his.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.his.common.R;
import com.example.his.dao.DrugsMapper;
import com.example.his.entity.Drugs;
import com.example.his.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class DrugServiceImp extends ServiceImpl<DrugsMapper, Drugs> implements DrugService {
    @Autowired
    private DrugsMapper drugsMapper;
    @Transactional
    public R<String> increase(String prescription,int num){
        drugsMapper.increase(prescription, num);
        return null;
    }
}
