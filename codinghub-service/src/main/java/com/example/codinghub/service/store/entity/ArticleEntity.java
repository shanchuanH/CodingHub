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
 * Entity representing the Article table.
 */
@Data
@Builder
@TableName("article")
public class ArticleEntity implements Serializable {

    /**
     * Primary key ID.
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * User ID associated with the article.
     */
    private Long userId;

    /**
     * Title of the article.
     */
    private String title;

    /**
     * Short title of the article.
     */
    private String shortTitle;

    /**
     * Summary of the article.
     */
    private String summary;

    /**
     * Status of the article: 0 for unpublished, 1 for published.
     */
    private Integer status;

    /**
     * Flag indicating whether the article is deleted.
     */
    private Integer deleted;

    /**
     * Creation timestamp of the article.
     */
    private LocalDateTime createTime;

    /**
     * Last update timestamp of the article.
     */
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}