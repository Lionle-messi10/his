package com.example.his.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.his.common.R;
import com.example.his.entity.Drugs;
import com.example.his.entity.Registration;
import com.example.his.entity.issue;
import com.example.his.service.DrugService;
import com.example.his.service.RegistrationService;
import com.example.his.service.issueService;
import com.example.his.service.userFeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/registration")
public class RegistrationController {
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private DrugService drugService;
    @Autowired
    private userFeeService userFeeService;
    @Autowired
    private issueService issueService;

    @GetMapping("/{currentPage}/{pageSize}")
    public R<Page<Registration>> page(@PathVariable int currentPage, @PathVariable int pageSize) {
        Page page = new Page(currentPage, pageSize);
        Page page1 = registrationService.page(page);
        return R.success(page1);
    }
//    public R<String> save(){
//        issueService.save()
//    }

    @PutMapping("/{prescription}/{vipId}/{num}")
    public R<String> charge(@PathVariable String prescription,@PathVariable String vipId,@PathVariable int num) {
        LambdaQueryWrapper<Drugs> objectLambdaQueryWrapper = new LambdaQueryWrapper<Drugs>();
        objectLambdaQueryWrapper.eq(Drugs::getPrescription,prescription);
        Drugs one = drugService.getOne(objectLambdaQueryWrapper);
        float price = one.getPrice();
        userFeeService.delete(vipId,price,num);
        userFeeService.save(vipId, prescription, num);
        return R.success("缴费成功");
    }
}
