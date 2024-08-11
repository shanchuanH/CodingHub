package com.example.codinghub.common.enums;

import lombok.Getter;

/**
 * Status of the article: 0 for unpublished, 1 for published.
 */
@Getter
public enum ArticlePublishStatus {
    UNPUBLISHED(0),
    PUBLISHED(1);

    private final int code;

    ArticlePublishStatus(int code) {
        this.code = code;
    }

    public static ArticlePublishStatus fromCode(int value) {
        for (ArticlePublishStatus status : ArticlePublishStatus.values()) {
            if (status.code == value) {
                return status;
            }
        }
        throw new IllegalArgumentException("Invalid article publish status value: " + value);
    }
}
