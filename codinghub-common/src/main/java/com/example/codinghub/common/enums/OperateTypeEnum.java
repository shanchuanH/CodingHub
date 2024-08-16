package com.example.codinghub.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum OperateTypeEnum {

    EMPTY(0, ""),
    READ(1, "阅读"),
    PRAISE(2, "点赞"),
    COLLECTION(3, "收藏"),
    CANCEL_PRAISE(4, "取消点赞"),
    CANCEL_COLLECTION(5, "取消收藏"),
    ;

    private final Integer code;
    private final String desc;

    public static OperateTypeEnum formCode(int code) {
        for (OperateTypeEnum value : OperateTypeEnum.values()) {
            if (value.getCode().equals(code)) {
                return value;
            }
        }
        return OperateTypeEnum.EMPTY;
    }
}