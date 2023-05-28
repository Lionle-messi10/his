package com.example.his.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.his.dao.RegistrationMapper;
import com.example.his.entity.Registration;
import com.example.his.service.RegistrationService;
import org.springframework.stereotype.Service;

@Service
public class RegistrationServiceImpl extends ServiceImpl<RegistrationMapper, Registration> implements RegistrationService {
}
