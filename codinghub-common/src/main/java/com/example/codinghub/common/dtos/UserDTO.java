package com.example.codinghub.common.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String thirdAccountId;
    private String userName;
    private String password;
    private Integer loginType;
    private Integer deleted;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}