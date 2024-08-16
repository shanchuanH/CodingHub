package com.example.codinghub.web.controllers;

import com.example.codinghub.common.enums.OperateTypeEnum;
import com.example.codinghub.common.vos.CommonResponse;
import com.example.codinghub.service.service.UserFootService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/articles/operations")
public class ArticleRestController {

    @Resource
    private UserFootService userFootService;

    /**
     * Perform an operation on an article (like, unlike, collect, uncollect).
     *
     * @param articleId   The ID of the article.
     * @param userId      The ID of the user performing the operation.
     * @param operateCode The type of operation to perform (like, unlike, collect, uncollect).
     * @return The updated article details.
     */
    @Operation(summary = "Operate on Article", description = "Performs an operation like liking or collecting on a specific article by ID")
    @PostMapping("/{articleId}")
    public CommonResponse<Boolean> operateOnArticle(@PathVariable String articleId,
                                                    @RequestParam String userId,
                                                    @RequestParam Integer operateCode) {
        userFootService.saveOrUpdateUserFoot(articleId, userId, OperateTypeEnum.formCode(operateCode));
        return CommonResponse.success(true);
    }
}
