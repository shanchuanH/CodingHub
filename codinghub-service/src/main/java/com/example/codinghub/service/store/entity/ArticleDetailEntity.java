package com.example.codinghub.service.store.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * Entity representing the ArticleDetail table.
 */
@Data
@Builder
@TableName("article_detail")
public class ArticleDetailEntity implements Serializable {

    /**
     * Primary key ID.
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * ID of the associated article.
     */
    private Long articleId;

    /**
     * Version number of the article.
     */
    private Integer version;

    /**
     * Content of the article.
     */
    private String content;

    /**
     * Flag indicating whether the article detail is deleted.
     */
    private Integer deleted;

    /**
     * Creation timestamp of the article detail.
     */
    private LocalDateTime createTime;

    /**
     * Last update timestamp of the article detail.
     */
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}