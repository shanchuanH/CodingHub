package com.example.codinghub.service.store.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@TableName("user_foot")
public class UserFootEntity implements Serializable {

    /**
     * Primary key ID.
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * User ID associated with the footprint.
     */
    private Long userId;

    /**
     * Document ID (article/comment).
     */
    private Long documentId;

    /**
     * Document type: 1 for article, 2 for comment.
     */
    private Integer documentType;

    /**
     * User ID of the person who published the document.
     */
    private Integer documentUserId;

    /**
     * Collection status: 0 for not collected, 1 for collected, 2 for uncollected.
     */
    private Integer collectionStat;

    /**
     * Read status: 0 for unread, 1 for read.
     */
    private Integer readStat;

    /**
     * Comment status: 0 for not commented, 1 for commented, 2 for deleted comment.
     */
    private Integer commentStat;

    /**
     * Praise status: 0 for not praised, 1 for praised, 2 for unpraised.
     */
    private Integer praiseStat;

    /**
     * Creation timestamp.
     */
    private LocalDateTime createTime;

    /**
     * Last update timestamp.
     */
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}
