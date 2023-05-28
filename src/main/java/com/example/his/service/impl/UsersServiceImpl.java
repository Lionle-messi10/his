package com.example.his.service.impl;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.his.dao.UsersMapper;
import com.example.his.entity.Users;
import com.example.his.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * @Date：2023/5/15 10:46
 * @Filename：UsersServiceImpl
 * 业务实现类
 */
@Service//交由spring管理
public class UsersServiceImpl extends ServiceImpl<UsersMapper, Users> implements UsersService {

}


