package com.example.codinghub.common.util;

import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.metadata.Type;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LocalDateTimeToStringConverter extends CustomConverter<LocalDateTime, String> {

    private static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    @Override
    public String convert(LocalDateTime source, Type<? extends String> destinationType) {
        return source != null ? source.format(formatter) : null;
    }

    
}