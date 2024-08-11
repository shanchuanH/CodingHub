package com.example.codinghub.common.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDetailDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long articleId;
    private Integer version;
    private String content;
    private Integer deleted;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
