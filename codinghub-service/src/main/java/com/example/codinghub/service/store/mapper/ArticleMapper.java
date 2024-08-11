package com.example.codinghub.service.store.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.codinghub.service.store.entity.ArticleEntity;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper extends BaseMapper<ArticleEntity> {
}