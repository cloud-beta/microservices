package com.beta.surveyservice.controller;

import com.beta.surveyservice.model.Survey;
import com.beta.surveyservice.service.SurveyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/")
public class RestApiController {

    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    SurveyRepository repository;


    @RequestMapping(value = "/survey/", method = RequestMethod.GET)
    public ResponseEntity<List<Survey>> listAllUsers() {

        Iterable<Survey> iterable = repository.findAll();
        List<Survey> survey = new ArrayList<>();

        for(Survey s : iterable){
            survey.add(s);
        }
        if (survey.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<Survey>>(survey, HttpStatus.OK);
    }

    public static final class SurveyData{
        private String phoneNumber;
        private Map<String, String> survey;

        public SurveyData() {
        }

        public SurveyData(String phoneNumber, Map<String, String> survey) {
            this.phoneNumber = phoneNumber;
            this.survey = survey;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public Map<String, String> getSurvey() {
            return survey;
        }

        public void setSurvey(Map<String, String> survey) {
            this.survey = survey;
        }
    }

    @RequestMapping(value = "/survey/", method = RequestMethod.POST)
    public ResponseEntity<?> createBook(@RequestBody SurveyData data) {
        logger.info("Get Survey Data: {}", data);
        Survey survey = new Survey();
        survey.setPhoneNumber(data.phoneNumber);
        survey.setSurvey(data.survey);
        ZonedDateTime utcNow = ZonedDateTime.now(ZoneOffset.of("+00:00"));
        survey.setTimestamp(utcNow.toOffsetDateTime().toString().replace("Z","+00:00"));
        logger.info("Creating Survey : {}", data);
        repository.save(survey);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }
}
