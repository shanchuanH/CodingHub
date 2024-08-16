package com.example.codinghub.service.service.impl;

import com.example.codinghub.common.dtos.UserFootDTO;
import com.example.codinghub.common.enums.OperateTypeEnum;
import com.example.codinghub.service.service.UserFootService;
import com.example.codinghub.service.store.accessor.UserFootAccessor;
import com.example.codinghub.service.store.entity.UserFootEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Supplier;

import static com.example.codinghub.service.convert.UserFootConvert.toUserFootDTO;

@Service
public class UserFootServiceImpl implements UserFootService {

    @Autowired
    private UserFootAccessor userFootAccessor;

    @Override
    public UserFootDTO saveOrUpdateUserFoot(String documentId, String userId, OperateTypeEnum operateType) {
        // Convert String documentId and userId to Long
        Long docId = Long.valueOf(documentId);
        Long usrId = Long.valueOf(userId);

        // Check if a record already exists
        UserFootEntity userFootEntity = userFootAccessor.lambdaQuery()
                .eq(UserFootEntity::getDocumentId, docId)
                .eq(UserFootEntity::getUserId, usrId)
                .one();

        if (userFootEntity == null) {
            userFootEntity = UserFootEntity.builder().build();
            userFootEntity.setDocumentId(docId);
            userFootEntity.setUserId(usrId);
            setUserFootStat(userFootEntity, operateType);
        } else {
            setUserFootStat(userFootEntity, operateType);
        }

        // Save or update the entity
        userFootAccessor.saveOrUpdate(userFootEntity);

        // Convert entity to DTO
        UserFootDTO userFootDTO = toUserFootDTO(userFootEntity);

        return userFootDTO;
    }

    private boolean setUserFootStat(UserFootEntity userFootEntity, OperateTypeEnum operateType) {
        switch (operateType) {
            case READ:
                userFootEntity.setReadStat(1);
                return true;
            case PRAISE:
                return compareAndUpdate(userFootEntity::getPraiseStat, userFootEntity::setPraiseStat, 1);
            case CANCEL_PRAISE:
                return compareAndUpdate(userFootEntity::getPraiseStat, userFootEntity::setPraiseStat, 0);
            case COLLECTION:
                return compareAndUpdate(userFootEntity::getCollectionStat, userFootEntity::setCollectionStat, 1);
            case CANCEL_COLLECTION:
                return compareAndUpdate(userFootEntity::getCollectionStat, userFootEntity::setCollectionStat, 0);
            default:
                return false;
        }
    }

    /**
     * 相同则直接返回false不用更新；不同则更新,返回true
     *
     * @param supplier
     * @param consumer
     * @param input
     * @param <T>
     * @return
     */
    private <T> boolean compareAndUpdate(Supplier<T> supplier, Consumer<T> consumer, T input) {
        if (Objects.equals(supplier.get(), input)) {
            return false;
        }
        consumer.accept(input);
        return true;
    }
}