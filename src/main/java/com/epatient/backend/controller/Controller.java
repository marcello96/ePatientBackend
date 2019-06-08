package com.epatient.backend.controller;

import com.epatient.backend.persistence.model.HeartRateData;
import com.epatient.backend.persistence.service.DataService;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    private DataService dataService;

    private final String crossOriginUrl = "http://localhost:3000";


    @Autowired
    public Controller(DataService dataService){
        this.dataService = dataService;
    }

    @RequestMapping("/")
    public String index() {
        return "Greetings from Spring Boot!";
    }

    @RequestMapping("/test")
    public String index2() {
        return "TEST!";
    }

    @RequestMapping(
            value = UrlRequest.URL_HEART_RATE_GET_BY_MIBAND_ID,
            method = RequestMethod.GET,
            produces = "application/json; charset=UTF-8")
    @CrossOrigin(origins = crossOriginUrl)
    public String getHeartRateByID(@PathVariable String id){
        ObjectMapper objectMapper = new ObjectMapper();
        System.out.println("Test");
        try {
            int h = dataService.getHeartRateByID(id);
            return objectMapper.writeValueAsString(h);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return UrlRequest.FAIL_RETURN_VALUE;
        }
    }
}