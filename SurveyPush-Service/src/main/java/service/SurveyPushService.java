package service;

import model.Book;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.POST;

import java.util.List;

public interface SurveyPushService {

    @POST("/push/survey")
    Call<Void> pushSurvey(@Body List<Book> books);
}
