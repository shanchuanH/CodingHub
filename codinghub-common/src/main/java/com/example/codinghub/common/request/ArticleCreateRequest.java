package com.example.codinghub.common.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ArticleCreateRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long userId;
    private String title;
    private String shortTitle;
    private String summary;
}