package com.beta.surveyservice.model;


import com.amazonaws.services.dynamodbv2.datamodeling.*;
import org.springframework.data.annotation.Id;

import java.util.Map;

@DynamoDBTable(tableName = "survey")
public class Survey {
    @Id
    private SurveyId surveyId;

    @DynamoDBAttribute(attributeName="survey")
    private Map<String, String> survey;

    @DynamoDBHashKey(attributeName = "phone_number")
    public String getPhoneNumber() {
        return surveyId != null ? surveyId.getPhoneNumber() : null;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (surveyId == null) {
            surveyId = new SurveyId();
        }
        surveyId.setPhoneNumber(phoneNumber);
    }

    @DynamoDBRangeKey(attributeName = "s_timestamp")
    public String getTimestamp() {
        return surveyId != null ? surveyId.getSTimestamp() : null;
    }

    public void setTimestamp(String timestamp) {
        if (surveyId == null) {
            surveyId = new SurveyId();
        }
        surveyId.setSTimestamp(timestamp);
    }

    public Map<String, String> getSurvey() {
        return survey;
    }

    public void setSurvey(Map<String, String> survey) {
        this.survey = survey;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "surveyId=" + surveyId +
                ", survey=" + survey +
                '}';
    }
}
