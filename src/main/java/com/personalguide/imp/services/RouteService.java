package com.personalguide.imp.services;

import com.personalguide.api.repository.IRouteRepository;
import com.personalguide.api.services.IRouteService;
import com.personalguide.imp.converter.Converter;
import com.personalguide.imp.dtos.RouteDto;
import com.personalguide.imp.entity.RouteEntity;
import com.personalguide.imp.localization.Messagei18n;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

@Service
@Data
@NoArgsConstructor
public class RouteService implements IRouteService {

    private IRouteRepository routeRepository;
    private Messagei18n messagei18n;
    private Converter<RouteDto, RouteEntity> converter;

    @Autowired
    public RouteService(IRouteRepository routeRepository,Messagei18n messagei18n, @Qualifier(value = "routConverter") Converter converter){
        this.routeRepository = routeRepository;
        this.messagei18n = messagei18n;
        this.converter = converter;
    }

    @Override
    public List<RouteDto> getAll(Locale locale) {
        return routeRepository.getAll().stream()
                .map( rout -> converter.convertToDtoWithLocale(rout,messagei18n,locale))
                .collect(Collectors.toList());
    }

    @Override
    public RouteDto getById(int id, Locale locale) {
        return routeRepository.getById(id)
                .map( rout -> converter.convertToDtoWithLocale(rout,messagei18n,locale))
                .orElse(null);
    }
}
