package com.personalguide.imp.configuration;

import com.personalguide.imp.converter.FoodConverter;
import com.personalguide.imp.converter.PlaceConverter;
import com.personalguide.imp.converter.RouteConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.personalguide.imp")
public class BeanConfiguration {

    @Bean
    public FoodConverter foodConverter(){
        return new FoodConverter();
    }

    @Bean
    public PlaceConverter placeConverter(){
        return new PlaceConverter();
    }

    @Bean
    public RouteConverter routConverter(){
        return new RouteConverter();
    }
}
