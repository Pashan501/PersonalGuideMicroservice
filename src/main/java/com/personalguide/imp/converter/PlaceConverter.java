package com.personalguide.imp.converter;

import com.personalguide.imp.dtos.PlaceDto;
import com.personalguide.imp.entity.PlaceEntity;
import com.personalguide.imp.localization.Messagei18n;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
@NoArgsConstructor
public class PlaceConverter extends Converter<PlaceDto,PlaceEntity> {


    @Override
    public PlaceDto convertToDtoWithLocale(PlaceEntity entity, Messagei18n messageSource, Locale locale) {
        PlaceDto placeDto = new PlaceDto();
        String[] texts = entity.getTexts().split("&&");

        placeDto.setId(entity.getId());
        placeDto.setTitle(messageSource.getMessage(entity.getTitle(),locale));
        placeDto.setDescription(messageSource.getMessage(entity.getDescription(),locale));
        placeDto.setTexts(convertTextWithLocale(texts,messageSource,locale));
        placeDto.setImageSources(entity.getImageSources());

        return placeDto;
    }


}
