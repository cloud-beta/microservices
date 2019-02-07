package com.beta.surveyservice.service;

import com.beta.surveyservice.model.Survey;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface SurveyRepository extends CrudRepository<Survey, String> {
}
