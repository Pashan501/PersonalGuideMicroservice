package com.personalguide.imp.services;

import com.personalguide.api.repository.IFoodRepository;
import com.personalguide.api.services.IFoodService;
import com.personalguide.imp.converter.Converter;
import com.personalguide.imp.converter.FoodConverter;
import com.personalguide.imp.dtos.FoodDto;
import com.personalguide.imp.entity.FoodEntity;
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
public class FoodService implements IFoodService {

    private  IFoodRepository foodRepository;
    private  Messagei18n messagei18n;
    private  Converter<FoodDto, FoodEntity> converter;

    @Autowired
    public FoodService(IFoodRepository foodRepository, Messagei18n messagei18n, @Qualifier(value = "foodConverter") Converter converter){
        this.foodRepository = foodRepository;
        this.messagei18n = messagei18n;
        this.converter = converter;
    }

    @Override
    public List<FoodDto> getAll(Locale locale) {
        return foodRepository.getAll().stream().map(food -> converter.convertToDtoWithLocale(food,messagei18n,locale)).collect(Collectors.toList());
    }

    @Override
    public FoodDto getById(int id, Locale locale) {
        return  foodRepository.getById(id).map(food -> converter.convertToDtoWithLocale(food,messagei18n,locale)).orElse(null);
    }

}
