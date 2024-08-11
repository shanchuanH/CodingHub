package com.example.codinghub.service.store.accessor.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.codinghub.service.store.accessor.ArticleDetailAccessor;
import com.example.codinghub.service.store.entity.ArticleDetailEntity;
import com.example.codinghub.service.store.mapper.ArticleDetailMapper;
import org.springframework.stereotype.Service;

/**
 * Accessor implementation for ArticleDetailEntity.
 */
@Service
public class ArticleDetailAccessorImpl extends ServiceImpl<ArticleDetailMapper, ArticleDetailEntity>
        implements ArticleDetailAccessor {
    @Override
    public ArticleDetailEntity getByArticleId(Long articleId) {
        LambdaQueryWrapper<ArticleDetailEntity> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(ArticleDetailEntity::getArticleId, articleId);
        ArticleDetailEntity articleDetailEntity = getOne(queryWrapper);
        if (articleDetailEntity == null) {
            log.warn("ArticleDetailEntity not found for articleId: " + articleId);
            return null;
        }
        return articleDetailEntity;
    }
    // You can add custom methods here
}