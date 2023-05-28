package com.example.his.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.his.common.R;
import com.example.his.common.Result;
import com.example.his.entity.Registration;
import com.example.his.entity.Users;
import com.example.his.entity.userFee;
import com.example.his.service.RegistrationService;
import com.example.his.service.UsersService;
import com.example.his.service.userFeeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Slf4j
@RestController//交给spring管理
@RequestMapping("/users")//窄化管理：给访问路径加个前缀
public class UsersController {
    @Autowired//注入service
    private UsersService usersService;
    @Autowired
    private RegistrationService registrationService;
    @Autowired
    private userFeeService userFeeService;
    @GetMapping("/{id}")
    public R<Users> getById(@PathVariable int id) {
        Users byId = usersService.getById(id);
        return R.success(byId);
    }
    @GetMapping("/doctor")
    public R<List<Users>> getDoctor() {
//        LambdaQueryWrapper<Users> objectLambdaQueryWrapper = new LambdaQueryWrapper<>();
//        objectLambdaQueryWrapper.eq(Users::getStatus,3);
        QueryWrapper<Users> wrapper = new QueryWrapper<>();
        wrapper.lambda().eq(Users::getStatus, 3).select(Users::getUserName);
        List<Users> names = usersService.list(wrapper);
        return R.success(names);
    }

    @GetMapping("/name/{page}/{pageSize}/{name}")
    public R<Page> page(@PathVariable int page, @PathVariable int pageSize, @PathVariable String name) {
        //分页构造器对象
        Page<Users> pageInfo = new Page<>(page, pageSize);

        LambdaQueryWrapper<Users> queryWrapper = new LambdaQueryWrapper<>();
        //添加查询条件，根据name进行like模糊查询
        queryWrapper.like(name != null, Users::getUserName, name);
        //添加排序条件，根据更新时间降序排列
//        queryWrapper.orderByDesc(Users::getUpdateTime);

        Page<Users> page1 = usersService.page(pageInfo, queryWrapper);
        return R.success(page1);

    }

    @GetMapping("/id/{id}/{nowPage}/{pageSize}")
    public R<Page<Users>> page(@PathVariable int id, @PathVariable int nowPage, @PathVariable int pageSize) {

        Page<Users> pageInfo = new Page<>(nowPage, pageSize);
        LambdaQueryWrapper<Users> objectLambdaQueryWrapper = new LambdaQueryWrapper<>();
        Page<Users> page = usersService.page(pageInfo, objectLambdaQueryWrapper);
        return R.success(pageInfo);
    }

    @GetMapping("/{currentPage}/{pageSize}")
    public R<Page<Users>> page(@PathVariable int currentPage, @PathVariable int pageSize) {
        Page pageInfo = new Page(currentPage, pageSize);
        Page page = usersService.page(pageInfo);
        return R.success(page);
    }
    @GetMapping("/fee/{currentPage}/{pageSize}")
    public R<Page<Users>> page2(@PathVariable int currentPage, @PathVariable int pageSize) {
        Page pageInfo = new Page(currentPage, pageSize);
        LambdaQueryWrapper<userFee> objectLambdaQueryWrapper = new LambdaQueryWrapper<>();
        objectLambdaQueryWrapper.eq(userFee::getUserName,"11035");
        Page page = userFeeService.page(pageInfo);
        return R.success(page);
    }

    @DeleteMapping("/{id}")
    public R<String> deleteById(@PathVariable int id) {
        boolean b = usersService.removeById(id);
        return R.success("删除成功");
    }

    @PutMapping
    public R<String> updateById(@RequestBody Users users) {
        usersService.updateById(users);
        return R.success("根据id修改成功");
    }

    @PostMapping("/save")
    public R<String> save(@RequestBody Users users, HttpServletResponse response) throws IOException {
        usersService.save(users);
        return R.success("添加成功");
    }

    @PostMapping("/login")
    public Result login(HttpServletRequest request,  @RequestBody Users users) throws ServletException, IOException {
        LambdaQueryWrapper<Users> Wrapper = new LambdaQueryWrapper<>();
        Wrapper.eq(Users::getUserName,users.getUserName());
        Users one = usersService.getOne(Wrapper);
        Result result = new Result("登陆成功");
        if (one == null) {
            return new Result("查无此人");
        }
        if (!one.getPassword().equals(users.getPassword())) {
            return new Result("密码错误");
        }
        log.info("登陆成功");
        request.getSession().setAttribute("users", users.getUserName());
        if(one.getStatus()==1) {
            log.info("跳转界面");
            result.setData(one);
            result.setCode(1);
        }
        if(one.getStatus()==2) {
            result.setData(one);
            result.setCode(2);
        }
        if(one.getStatus()==3) {
            result.setData(one);
            result.setCode(3);
        }

        return result;
    }

    @PostMapping("/loginOut")
    public boolean loginout(HttpServletRequest request, @RequestBody Users users) {
        if (true) {
            request.getSession().removeAttribute("users");
        }
        return true;
    }
    @PostMapping("/registration/save")
    public R<String> registration(@RequestBody Registration registration) throws IOException {
        registrationService.save(registration);
        return R.success("添加成功");
    }
    @PostMapping("/fee/save")
    public R<String> fee(@RequestBody userFee userFee) throws IOException {
        userFeeService.increase(userFee.getVipId(),userFee.getRechargeMoney());
        return R.success("添加成功");
    }

}


