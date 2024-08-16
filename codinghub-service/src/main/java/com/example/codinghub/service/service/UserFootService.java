package com.example.codinghub.service.service;

import com.example.codinghub.common.dtos.UserFootDTO;
import com.example.codinghub.common.enums.OperateTypeEnum;

public interface UserFootService {
    /**
     * 保存或更新用户足迹
     *
     * @param DocumentId
     * @param userId
     * @param operateType
     * @return
     */
    UserFootDTO saveOrUpdateUserFoot(String DocumentId, String userId, OperateTypeEnum operateType);
}
