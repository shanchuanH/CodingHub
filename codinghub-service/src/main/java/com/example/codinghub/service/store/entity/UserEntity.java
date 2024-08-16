package com.example.codinghub.service.store.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@Builder
@TableName("user")
public class UserEntity implements Serializable {

    /**
     * Primary key ID.
     */
    @TableId(type = IdType.AUTO)
    private Long id;

    /**
     * Third-party user ID.
     */
    private String thirdAccountId;

    /**
     * Username.
     */
    private String userName;

    /**
     * Password.
     */
    private String password;

    /**
     * Login type: 0 for WeChat login, 1 for username/password login.
     */
    private Integer loginType;

    /**
     * Deletion flag.
     */
    private Integer deleted;

    /**
     * Creation timestamp.
     */
    private LocalDateTime createTime;

    /**
     * Last update timestamp.
     */
    private LocalDateTime updateTime;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}