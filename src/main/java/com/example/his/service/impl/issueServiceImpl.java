package com.example.his.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.his.dao.issueMapper;
import com.example.his.entity.issue;
import com.example.his.service.issueService;
import org.springframework.stereotype.Service;

@Service
public class issueServiceImpl extends ServiceImpl<issueMapper, issue> implements issueService {
}