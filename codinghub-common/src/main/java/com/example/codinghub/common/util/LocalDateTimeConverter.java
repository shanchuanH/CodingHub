package com.example.codinghub.common.util;

import ma.glasnost.orika.CustomConverter;
import ma.glasnost.orika.metadata.Type;

import java.time.LocalDateTime;

public class LocalDateTimeConverter extends CustomConverter<LocalDateTime, LocalDateTime> {

    @Override
    public LocalDateTime convert(LocalDateTime source, Type<? extends LocalDateTime> destinationType) {
        return source != null ? LocalDateTime.from(source) : null;
    }
}