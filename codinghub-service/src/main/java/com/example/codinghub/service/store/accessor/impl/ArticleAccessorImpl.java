package com.example.codinghub.service.store.accessor.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.codinghub.service.store.accessor.ArticleAccessor;
import com.example.codinghub.service.store.entity.ArticleEntity;
import com.example.codinghub.service.store.mapper.ArticleMapper;
import org.springframework.stereotype.Service;

/**
 * Accessor implementation for ArticleEntity.
 */
@Service
public class ArticleAccessorImpl extends ServiceImpl<ArticleMapper, ArticleEntity> implements ArticleAccessor {
    // You can add custom methods here
}