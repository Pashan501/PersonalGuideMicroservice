package com.personalguide.imp.resource;

import com.personalguide.api.services.IRouteService;
import com.personalguide.imp.dtos.RouteDto;
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
@RequestMapping("/route")
public class RoutResource {

    private IRouteService routeService;

    @Autowired
    public RoutResource(IRouteService routeService){
        this.routeService = routeService;
    }

    @GetMapping
    public ResponseEntity<List<RouteDto>> getAll(@RequestHeader("accept-language") String language){
        return new ResponseEntity<>(routeService.getAll(new Locale(language)), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable int id,@RequestHeader("accept-language") String language){
        RouteDto routeDto = routeService.getById(id,new Locale(language));
        if(routeDto != null){
            return new ResponseEntity<>(routeDto,HttpStatus.OK);
        }else{
            Message message = new Message(Collections.singletonList("No object found"),HttpStatus.NOT_FOUND.value());
            return new ResponseEntity(message,HttpStatus.NOT_FOUND);
        }
    }
}
