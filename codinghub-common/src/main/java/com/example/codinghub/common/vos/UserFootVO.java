package com.example.codinghub.common.vos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFootVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private Long userId;
    private Long documentId;
    private Integer documentType;
    private Integer documentUserId;
    private Integer collectionStat;
    private Integer readStat;
    private Integer commentStat;
    private Integer praiseStat;
    private String createTime;
    private String updateTime;
}
