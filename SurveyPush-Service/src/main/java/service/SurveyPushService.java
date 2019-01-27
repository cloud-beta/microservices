package service;

import model.Books;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

public interface SurveyPushService {

    @POST("/groups/")
    Call<Void> pushSurvey(@Body Books books);
}
