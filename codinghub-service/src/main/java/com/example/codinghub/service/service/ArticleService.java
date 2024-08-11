package com.example.codinghub.service.service;

import com.example.codinghub.common.dtos.ArticleDTO;
import com.example.codinghub.common.dtos.ArticleDetailDTO;
import com.example.codinghub.common.request.ArticleCreateRequest;
import com.example.codinghub.common.request.ArticleEditRequest;

import java.util.List;


public interface ArticleService {
    ArticleDTO describeArticle(String articleId);

    ArticleDetailDTO describeArticleDetail(String articleId);

    List<ArticleDTO> listAllArticles();

    ArticleDetailDTO getFullArticle(Long id);

    ArticleDTO createArticle(ArticleCreateRequest request);

    ArticleDTO editArticle(Long id, ArticleEditRequest request);

    boolean deleteArticle(Long id);

    ArticleDTO getArticle(Long id);
}
