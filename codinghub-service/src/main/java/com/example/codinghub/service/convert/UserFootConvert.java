package com.example.codinghub.service.convert;

import com.example.codinghub.common.dtos.UserFootDTO;
import com.example.codinghub.common.util.LocalDateTimeConverter;
import com.example.codinghub.service.store.entity.UserFootEntity;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class UserFootConvert {
    private static final MapperFacade singleMapperFacade;

    static {
        singleMapperFacade = init();
    }

    public static UserFootDTO toUserFootDTO(UserFootEntity userFootEntity) {
        return singleMapperFacade.map(userFootEntity, UserFootDTO.class);
    }

    private static MapperFacade init() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();

        mapperFactory.getConverterFactory().registerConverter(new LocalDateTimeConverter());

        return mapperFactory.getMapperFacade();
    }

}
