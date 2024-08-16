package com.example.codinghub.service.store.accessor.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.codinghub.service.store.accessor.UserAccessor;
import com.example.codinghub.service.store.entity.UserEntity;
import com.example.codinghub.service.store.mapper.UserMapper;
import org.springframework.stereotype.Service;

@Service
public class UserAccessorImpl extends ServiceImpl<UserMapper, UserEntity> implements UserAccessor {
    // You can add custom methods here
}