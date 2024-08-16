package com.example.codinghub.service.store.accessor.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.codinghub.service.store.accessor.UserFootAccessor;
import com.example.codinghub.service.store.entity.UserFootEntity;
import com.example.codinghub.service.store.mapper.UserFootMapper;
import org.springframework.stereotype.Service;

/**
 * Accessor implementation for UserFootEntity.
 */
@Service
public class UserFootAccessorImpl extends ServiceImpl<UserFootMapper, UserFootEntity> implements UserFootAccessor {
    // You can add custom methods here
}
