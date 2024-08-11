package com.example.codinghub.common.dtos;

import com.example.codinghub.common.enums.ArticlePublishStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long userId;
    private String title;
    private ArticlePublishStatus status;
    private String shortTitle;
    private String summary;
    private Integer deleted;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}