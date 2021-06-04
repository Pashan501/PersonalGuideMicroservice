package com.personalguide.imp.resource;

import com.personalguide.api.services.IPlaceService;
import com.personalguide.imp.dtos.PlaceDto;
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
@RequestMapping("/place")
public class PlaceResource {

    private final IPlaceService placeService;

    @Autowired
    public PlaceResource(IPlaceService placeService){
        this.placeService = placeService;
    }

    @GetMapping
    public ResponseEntity<List<PlaceDto>> getAll(@RequestHeader("accept-language") String language){
        return new ResponseEntity<>(
                placeService.getAll(new Locale(language)),
                HttpStatus.OK
                );
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Integer id,@RequestHeader("accept-language") String language){
       Locale locale = new Locale(language);
       PlaceDto placeDTO = placeService.getById(id,locale);
       if(placeDTO != null){
           return new ResponseEntity<>(placeDTO,HttpStatus.OK);
       }else{
           Message message = new Message(Collections.singletonList("No object found"),HttpStatus.NOT_FOUND.value());
           return new ResponseEntity(message,HttpStatus.NOT_FOUND);
       }
    }

}
