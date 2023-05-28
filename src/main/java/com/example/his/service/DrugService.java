package com.example.his.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.his.common.R;
import com.example.his.entity.Drugs;
import org.springframework.transaction.annotation.Transactional;

public interface DrugService extends IService<Drugs> {
   R<String> increase(String prescription, int num);
}
