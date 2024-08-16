package com.example.codinghub.web.controllers;

import com.example.codinghub.common.dtos.ArticleDTO;
import com.example.codinghub.common.dtos.ArticleDetailDTO;
import com.example.codinghub.common.request.ArticleCreateRequest;
import com.example.codinghub.common.request.ArticleEditRequest;
import com.example.codinghub.common.vos.ArticleDetailVO;
import com.example.codinghub.common.vos.ArticleVO;
import com.example.codinghub.common.vos.CommonResponse;
import com.example.codinghub.service.service.ArticleService;
import com.example.codinghub.web.convert.ArticleConvert;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/api/articles")
@Tag(name = "Article Management", description = "Operations related to articles")
public class ArticleController {

    @Resource
    private ArticleService articleService;

    /**
     * Preview a list of articles.
     *
     * @return A list of article previews.
     */
    @Operation(summary = "Preview Articles", description = "Returns a list of articles for preview")
    @GetMapping("/listAllArticles")
    public CommonResponse<List<ArticleVO>> listAllArticles() {
        List<ArticleDTO> articleDTOs = articleService.listAllArticles();
        List<ArticleVO> articleVOs = articleDTOs.stream()
                .map(ArticleConvert::toArticleVO)
                .collect(Collectors.toList());
        return CommonResponse.success(articleVOs);
    }

    @Operation(summary = "Preview Article", description = "Returns a specific article for preview")
    @GetMapping("/preview/{id}")
    public CommonResponse<ArticleVO> previewArticle(@PathVariable Long id) {
        ArticleDTO articleDTO = articleService.getArticle(id);
        ArticleVO articleVO = ArticleConvert.toArticleVO(articleDTO);
        return CommonResponse.success(articleVO);
    }

    /**
     * Get the full details of an article.
     *
     * @param id The ID of the article.
     * @return The full article details.
     */
    @Operation(summary = "Get Full Article", description = "Returns the full details of a specific article")
    @GetMapping("/detail/{id}")
    public CommonResponse<ArticleDetailVO> getFullArticle(@PathVariable Long id) {
        ArticleDetailDTO fullArticle = articleService.getFullArticle(id);
        ArticleDetailVO articleDetailVO = ArticleConvert.toArticleDetailVO(fullArticle);
        return CommonResponse.success(articleDetailVO);
    }

    /**
     * Create a new article.
     *
     * @param request The data to create the article.
     * @return The created article.
     */
    @Operation(summary = "Create Article", description = "Creates a new article with the provided data")
    @PostMapping("/create")
    public CommonResponse<ArticleVO> createArticle(@RequestBody ArticleCreateRequest request) {
        ArticleDTO createdArticleDTO = articleService.createArticle(request);
        ArticleVO articleVO = ArticleConvert.toArticleVO(createdArticleDTO);
        return CommonResponse.success(articleVO);
    }

    /**
     * Edit an existing article.
     *
     * @param id      The ID of the article to edit.
     * @param request The new data for the article.
     * @return The updated article.
     */
    @Operation(summary = "Edit Article", description = "Edits an existing article with the provided data")
    @PostMapping("/{id}")
    public CommonResponse<ArticleVO> editArticle(@PathVariable Long id, @RequestBody ArticleEditRequest request) {
        ArticleDTO updatedArticleDTO = articleService.editArticle(id, request);
        ArticleVO articleVO = ArticleConvert.toArticleVO(updatedArticleDTO);
        return CommonResponse.success(articleVO);
    }

    /**
     * Delete an article.
     *
     * @param id The ID of the article to delete.
     * @return A message indicating the result.
     */
    @Operation(summary = "Delete Article", description = "Deletes a specific article by ID")
    @DeleteMapping("/{id}")
    public CommonResponse<String> deleteArticle(@PathVariable Long id) {
        boolean isDeleted = articleService.deleteArticle(id);
        return isDeleted ? CommonResponse.success("Article deleted successfully")
                : CommonResponse.error(400, "Failed to delete the article");
    }
}
