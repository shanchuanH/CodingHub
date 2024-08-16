package com.example.codinghub.common.vos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserVO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;
    private String thirdAccountId;
    private String userName;
    private String password;
    private Integer loginType;
    private Integer deleted;
    private String createTime;
    private String updateTime;
}
