package com.example.codinghub.service.store.accessor;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.codinghub.service.store.entity.ArticleDetailEntity;

/**
 * Accessor interface for ArticleDetailEntity.
 */
public interface ArticleDetailAccessor extends IService<ArticleDetailEntity> {
    ArticleDetailEntity getByArticleId(Long id);
    // You can add custom methods here
}