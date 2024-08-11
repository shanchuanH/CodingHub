package com.example.codinghub.service.convert;

import com.example.codinghub.common.dtos.ArticleDTO;
import com.example.codinghub.common.dtos.ArticleDetailDTO;
import com.example.codinghub.common.util.LocalDateTimeConverter;
import com.example.codinghub.service.store.entity.ArticleDetailEntity;
import com.example.codinghub.service.store.entity.ArticleEntity;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class ArticleConvert {
    private static final MapperFacade singleMapperFacade;

    static {
        singleMapperFacade = init();
    }

    public static ArticleDTO toArticleDTO(ArticleEntity articleEntity) {
        return singleMapperFacade.map(articleEntity, ArticleDTO.class);
    }

    public static ArticleDetailDTO toArticleDetailDTO(ArticleDetailEntity entity) {
        return singleMapperFacade.map(entity, ArticleDetailDTO.class);
    }

    private static MapperFacade init() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();

        mapperFactory.getConverterFactory().registerConverter(new LocalDateTimeConverter());

        mapperFactory.classMap(ArticleEntity.class, ArticleDTO.class)
                .field("status", "status.code")
                .byDefault()
                .register();

        return mapperFactory.getMapperFacade();
    }
}
