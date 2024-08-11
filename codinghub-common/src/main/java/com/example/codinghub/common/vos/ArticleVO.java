package com.example.codinghub.common.vos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * View Object for ArticleEntity.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long userId;
    private String title;
    private String shortTitle;
    private String summary;
    private Integer status;
    private Integer deleted;
    private String createTime;
    private String updateTime;

}