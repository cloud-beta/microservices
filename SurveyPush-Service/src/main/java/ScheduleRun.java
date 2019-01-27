import model.Books;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import service.BooksService;
import service.SurveyPushService;

import java.io.IOException;

public class ScheduleRun {

    public static void main(String[] args) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.lms.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final BooksService booksService = retrofit.create(BooksService.class);
        final SurveyPushService surveyPushService = retrofit.create(SurveyPushService.class);

        Call<Books> call = booksService.listBooks();

        call.enqueue(new Callback<Books>() {
            @Override
            public void onResponse(Call<Books> call, Response<Books> response) {
                Call<Void> pushCall = surveyPushService.pushSurvey(response.body());
                try {
                    pushCall.execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<Books> call, Throwable t) {

            }
        });
    }
}
