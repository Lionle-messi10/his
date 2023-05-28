package com.example.his.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.his.dao.diagnosisMapper;
import com.example.his.entity.Diagnosis;
import com.example.his.service.diagnosisService;
import org.springframework.stereotype.Service;

@Service
public class diagnosisServiceImpl extends ServiceImpl<diagnosisMapper, Diagnosis> implements diagnosisService {
}
