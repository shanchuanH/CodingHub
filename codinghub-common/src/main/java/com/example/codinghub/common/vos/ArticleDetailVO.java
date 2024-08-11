package com.example.codinghub.common.vos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleDetailVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long articleId;
    private Integer version;
    private String content;
    private Integer deleted;
    private String createTime;
    private String updateTime;

    // Additional fields or formatting for the view can be added here
}