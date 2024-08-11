package com.example.codinghub.web.convert;

import com.example.codinghub.common.dtos.ArticleDTO;
import com.example.codinghub.common.dtos.ArticleDetailDTO;
import com.example.codinghub.common.util.LocalDateTimeToStringConverter;
import com.example.codinghub.common.vos.ArticleDetailVO;
import com.example.codinghub.common.vos.ArticleVO;
import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

public class ArticleConvert {
    private static final MapperFacade singleMapperFacade;

    static {
        singleMapperFacade = init();
    }

    public static ArticleVO toArticleVO(ArticleDTO articleDTO) {
        return singleMapperFacade.map(articleDTO, ArticleVO.class);
    }

    public static ArticleDetailVO toArticleDetailVO(ArticleDetailDTO articleDetailDTO) {
        return singleMapperFacade.map(articleDetailDTO, ArticleDetailVO.class);
    }


    private static MapperFacade init() {
        MapperFactory mapperFactory = new DefaultMapperFactory.Builder().mapNulls(false).build();
        mapperFactory.getConverterFactory().registerConverter(new LocalDateTimeToStringConverter());
        mapperFactory.classMap(ArticleDTO.class, ArticleVO.class)
                .field("status.code", "status")
                .byDefault()
                .register();

        return mapperFactory.getMapperFacade();
    }
}
