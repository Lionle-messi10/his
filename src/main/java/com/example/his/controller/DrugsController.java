package com.example.his.controller;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.his.common.R;
import com.example.his.entity.Drugs;
import com.example.his.service.DrugService;
import com.example.his.service.issueService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.annotations.Update;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/drug")
public class DrugsController {
    @Autowired
    private DrugService drugService;
    @Autowired
    private issueService issueService;

    @GetMapping("/{name}/{pageSize}/{currentPage}")
    public R<Page> page(@PathVariable String name, @PathVariable int pageSize, @PathVariable int currentPage) {
        Page<Drugs> drugsPage = new Page<>(currentPage, pageSize);
        LambdaQueryWrapper<Drugs> objectLambdaQueryWrapper = new LambdaQueryWrapper<>();
        objectLambdaQueryWrapper.like(name != null, Drugs::getPrescription, name);
        Page<Drugs> page = drugService.page(drugsPage, objectLambdaQueryWrapper);
        return R.success(page);
    }

    @GetMapping("/name/{name}")
    public R<Drugs> page(@PathVariable String name) {
        LambdaQueryWrapper<Drugs> objectLambdaQueryWrapper = new LambdaQueryWrapper<>();
        objectLambdaQueryWrapper.eq(name != null, Drugs::getPrescription, name);
        Drugs one = drugService.getOne(objectLambdaQueryWrapper);
        return R.success(one);
    }

    @PostMapping("/save")
    public R<String> save(@RequestBody Drugs drugs) {
        drugService.save(drugs);
        return R.success("添加成功");
    }

    @DeleteMapping("/{id}")
    public R<String> deleteById(@PathVariable int id) {
        issueService.removeById(id);
        return R.success("删除成功");
    }

    @PutMapping("/{prescription}/{num}")
    public R<String> charge(@PathVariable String prescription, @PathVariable int num) {
        drugService.increase(prescription, num);
        return R.success("发药成功");
    }
}
