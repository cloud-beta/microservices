package com.beta.informationservice.controller;

import com.beta.informationservice.model.Place;
import com.beta.informationservice.service.InfoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/information")
public class RestApiController {

    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    InfoService infoService; //Service which will do all data retrieval/manipulation work

    // -------------------Retrieve All Users---------------------------------------------

    @RequestMapping(value = "/places/", method = RequestMethod.GET)
    public ResponseEntity<List<Place>> listAllUsers() {
        Iterable<Place> iterator = infoService.findAll();
        List<Place> places = new ArrayList<>();

        for (Place place : infoService.findAll()) {
            places.add(place);
        }

        if (places.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Place>>(places, HttpStatus.OK);
    }

}