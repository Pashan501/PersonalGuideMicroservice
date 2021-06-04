package com.personalguide.imp.resource;

import com.personalguide.api.services.IFoodService;
import com.personalguide.imp.dtos.FoodDto;
import com.personalguide.imp.validation.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Locale;

@RestController
@RequestMapping("/food")
public class FoodResource {

    private final IFoodService foodService;

    @Autowired
    public FoodResource(IFoodService foodService){
        this.foodService = foodService;
    }

    @GetMapping
    public ResponseEntity<List<FoodDto>> getAll(@RequestHeader("accept-language") String language){
        Locale locale = new Locale(language);
        return new ResponseEntity<>(
                foodService.getAll(new Locale(language)),
                HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getId(@PathVariable int id,@RequestHeader("accept-language") String language){
        FoodDto foodDto = foodService.getById(id,new Locale(language));
        if(foodDto != null){
            return new ResponseEntity<>(foodDto,HttpStatus.OK);
        }else{
            Message message = new Message(Collections.singletonList("No object found"),HttpStatus.NOT_FOUND.value());
            return new ResponseEntity(message,HttpStatus.NOT_FOUND);
        }
    }
}
