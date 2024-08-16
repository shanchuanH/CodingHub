package com.example.codinghub.common.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserFootDTO implements Serializable {

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
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
