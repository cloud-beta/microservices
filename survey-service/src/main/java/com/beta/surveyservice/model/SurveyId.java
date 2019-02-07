package com.beta.surveyservice.model;

import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBHashKey;
import com.amazonaws.services.dynamodbv2.datamodeling.DynamoDBRangeKey;

public class SurveyId {

    private static final long serialVersionUID = 1L;

    private String phoneNumber;

    private String sTimestamp;

    @DynamoDBHashKey
    public String getPhoneNumber() {
        return phoneNumber;
    }


    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @DynamoDBRangeKey
    public String getSTimestamp() {
        return sTimestamp;
    }


    public void setSTimestamp(String timestamp) {
        this.sTimestamp = timestamp;
    }

    @Override
    public String toString() {
        return "SurveyId{" +
                "phoneNumber='" + phoneNumber + '\'' +
                ", sTimestamp='" + sTimestamp + '\'' +
                '}';
    }
}
