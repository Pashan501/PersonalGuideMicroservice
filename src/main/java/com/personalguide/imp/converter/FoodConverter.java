package com.personalguide.imp.converter;

import com.personalguide.imp.dtos.FoodDto;
import com.personalguide.imp.entity.FoodEntity;
import com.personalguide.imp.localization.Messagei18n;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Locale;


@Component
@NoArgsConstructor
public class FoodConverter extends  Converter<FoodDto,FoodEntity> {

    @Override
    public FoodDto convertToDtoWithLocale(FoodEntity entity, Messagei18n messageSource, Locale locale) {
        FoodDto placeDto = new FoodDto();
        String[] texts = entity.getTexts().split("&&");

        placeDto.setId(entity.getId());
        placeDto.setTitle(messageSource.getMessage(entity.getTitle(),locale));
        placeDto.setDescription(messageSource.getMessage(entity.getDescription(),locale));
        placeDto.setTexts(convertTextWithLocale(texts,messageSource,locale));
        placeDto.setImageSources(entity.getImageSources());

        return placeDto;
    }
}
