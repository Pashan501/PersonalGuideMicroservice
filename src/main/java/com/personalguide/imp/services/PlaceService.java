package com.personalguide.imp.services;

import com.personalguide.api.repository.IPlaceRepository;
import com.personalguide.api.services.IPlaceService;
import com.personalguide.imp.converter.Converter;
import com.personalguide.imp.dtos.PlaceDto;
import com.personalguide.imp.entity.PlaceEntity;
import com.personalguide.imp.localization.Messagei18n;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
public class PlaceService implements IPlaceService {


    private final IPlaceRepository placeRepository;
    private final Messagei18n messagei18n;
    private final Converter<PlaceDto,PlaceEntity> converter;

    @Autowired
    public PlaceService(IPlaceRepository placeRepository, Messagei18n messagei18n, @Qualifier(value = "placeConverter") Converter converter){
        this.placeRepository = placeRepository;
        this.messagei18n = messagei18n;
        this.converter = converter;
    }

    @Override
    public List<PlaceDto> getAll(Locale locale) {
        return placeRepository.getAll().stream()
                .map( place -> converter.convertToDtoWithLocale(place,messagei18n,locale))
                .collect(Collectors.toList());
    }

    @Override
    public PlaceDto getById(int id, Locale locale) {
        return placeRepository.getById(id)
                .map( place -> converter.convertToDtoWithLocale(place,messagei18n,locale))
                .orElse(null);
    }
}
