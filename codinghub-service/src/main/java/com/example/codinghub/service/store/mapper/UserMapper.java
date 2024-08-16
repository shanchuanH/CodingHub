package com.example.codinghub.service.store.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.codinghub.service.store.entity.UserEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper extends BaseMapper<UserEntity> {
}