package com.example.codinghub.common.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * Request class for editing an article.
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleEditRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;
    private String title;
    private String shortTitle;
    private String summary;
}