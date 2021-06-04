package com.personalguide.imp.converter;

import com.personalguide.imp.dtos.PlaceDto;
import com.personalguide.imp.dtos.RouteDto;
import com.personalguide.imp.entity.RouteEntity;
import com.personalguide.imp.localization.Messagei18n;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@NoArgsConstructor
public class RouteConverter extends Converter<RouteDto,RouteEntity> {

    @Override
    public RouteDto convertToDtoWithLocale(RouteEntity entity, Messagei18n messageSource, Locale locale) {
        RouteDto routeDto = new RouteDto();
        String[] texts = entity.getTexts().split("&&");

        routeDto.setId(entity.getId());
        routeDto.setTitle(messageSource.getMessage(entity.getTitle(),locale));
        routeDto.setDescription(messageSource.getMessage(entity.getDescription(),locale));
        routeDto.setTexts(convertTextWithLocale(texts,messageSource,locale));

        return routeDto;
    }
}
