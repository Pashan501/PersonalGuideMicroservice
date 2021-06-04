package com.personalguide.imp.converter;

import com.personalguide.imp.localization.Messagei18n;

import java.util.Arrays;
import java.util.Locale;

public abstract class Converter<T,K> {

    public abstract T convertToDtoWithLocale(K entity, Messagei18n messageSource, Locale locale);

    protected String convertTextWithLocale(String [] texts, Messagei18n messageSource, Locale locale){
        StringBuilder stringBuilder = new StringBuilder();
        Arrays.asList(texts).forEach(text -> stringBuilder.append(messageSource.getMessage(text,locale)));

        return stringBuilder.toString();
    }
}
