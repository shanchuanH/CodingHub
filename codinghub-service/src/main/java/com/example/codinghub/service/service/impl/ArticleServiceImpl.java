package com.example.codinghub.service.service.impl;

import com.example.codinghub.common.dtos.ArticleDTO;
import com.example.codinghub.common.dtos.ArticleDetailDTO;
import com.example.codinghub.common.request.ArticleCreateRequest;
import com.example.codinghub.common.request.ArticleEditRequest;
import com.example.codinghub.service.convert.ArticleConvert;
import com.example.codinghub.service.service.ArticleService;
import com.example.codinghub.service.store.accessor.ArticleAccessor;
import com.example.codinghub.service.store.accessor.ArticleDetailAccessor;
import com.example.codinghub.service.store.entity.ArticleDetailEntity;
import com.example.codinghub.service.store.entity.ArticleEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

import static com.example.codinghub.service.convert.ArticleConvert.toArticleDTO;
import static com.example.codinghub.service.convert.ArticleConvert.toArticleDetailDTO;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Resource
    private ArticleAccessor articleAccessor;

    @Resource
    private ArticleDetailAccessor articleDetailAccessor;

    @Override
    public List<ArticleDTO> listAllArticles() {
        List<ArticleEntity> articles = articleAccessor.list();
        return articles.stream()
                .map(ArticleConvert::toArticleDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ArticleDetailDTO getFullArticle(Long id) {
        ArticleDetailEntity articleDetailEntity = articleDetailAccessor.getByArticleId(id);
        return toArticleDetailDTO(articleDetailEntity);
    }

    @Override
    public ArticleDTO createArticle(ArticleCreateRequest request) {
        ArticleEntity articleEntity = ArticleEntity.builder()
                .userId(request.getUserId())
                .title(request.getTitle())
                .shortTitle(request.getShortTitle())
                .summary(request.getSummary())
                .build();

        articleAccessor.save(articleEntity);

        return toArticleDTO(articleEntity);
    }

    @Override
    public ArticleDTO editArticle(Long id, ArticleEditRequest request) {
        ArticleEntity articleEntity = articleAccessor.getById(id);
        articleEntity = ArticleEntity.builder()
                .id(id)
                .userId(request.getUserId())
                .title(request.getTitle())
                .shortTitle(request.getShortTitle())
                .summary(request.getSummary())
                .build();

        articleAccessor.updateById(articleEntity);

        return toArticleDTO(articleEntity);
    }

    @Override
    public boolean deleteArticle(Long id) {
        return articleAccessor.removeById(id);
    }

    @Override
    public ArticleDTO getArticle(Long id) {
        ArticleEntity articleEntity = articleAccessor.getById(id);
        return toArticleDTO(articleEntity);
    }

    @Override
    public ArticleDTO describeArticle(String articleId) {
        ArticleEntity articleEntity = articleAccessor.getById(articleId);
        return toArticleDTO(articleEntity);
    }

    @Override
    public ArticleDetailDTO describeArticleDetail(String articleId) {
        ArticleDetailEntity articleDetailEntity = articleDetailAccessor.getById(articleId);
        return toArticleDetailDTO(articleDetailEntity);
    }

}
