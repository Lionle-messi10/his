package com.example.his.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.his.common.R;
import com.example.his.entity.Drugs;
import com.example.his.entity.Diagnosis;
import com.example.his.entity.Users;
import com.example.his.service.DrugService;
import com.example.his.service.diagnosisService;
import com.example.his.service.issueService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/doctor")
public class doctorController {
    @Autowired
    private DrugService drugService;
    @Autowired
    private issueService issueService;
    @Autowired
    private diagnosisService diagnosisService;
    @GetMapping("/id/{id}")
    public R<Diagnosis> getById(@PathVariable int id) {
        Diagnosis byId = diagnosisService.getById(id);
        return R.success(byId);
    }
    @GetMapping("/{name}/{pageSize}/{currentPage}")
    public R<Page> page(@PathVariable String name, @PathVariable int pageSize , @PathVariable int currentPage){
        Page<Drugs> drugsPage = new Page<>(currentPage,pageSize);
        LambdaQueryWrapper<Drugs> objectLambdaQueryWrapper = new LambdaQueryWrapper<>();
        objectLambdaQueryWrapper.like(name!=null,Drugs::getPrescription,name);
        Page<Drugs> page = drugService.page(drugsPage, objectLambdaQueryWrapper);
        return R.success(page);
    }
    @GetMapping("/diagnosis/{pageSize}/{currentPage}")
    public R<Page> page2( @PathVariable int pageSize , @PathVariable int currentPage){
        Page page1 = new Page(pageSize, currentPage);
        Page page = diagnosisService.page(page1);
        return R.success(page);
    }
    @GetMapping("/issue/{pageSize}/{currentPage}")
    public R<Page> page3( @PathVariable int pageSize , @PathVariable int currentPage){
        Page page1 = new Page(pageSize, currentPage);
        Page page = issueService.page(page1);
        return R.success(page);
    }
    @PutMapping
    public R<String> updateById(@RequestBody Diagnosis diagnosis) {
        diagnosisService.updateById(diagnosis);
        return R.success("修改成功");
    }
    @PostMapping("/save")
    public R<String> save(@RequestBody Diagnosis diagnosis){
        diagnosisService.save(diagnosis);
        return R.success("添加成功");
    }

    @DeleteMapping("/{id}")
    public R<String> deleteById(@PathVariable int id){
        drugService.removeById(id);
        return R.success("删除成功");
    }
    @DeleteMapping("/diagnosis/{id}")
    public R<String> deleteById2(@PathVariable int id){
        diagnosisService.removeById(id);
        return R.success("删除成功");
    }
}

