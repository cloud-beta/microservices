import model.Book;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import service.BooksService;
import service.SurveyPushService;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class ScheduleRun {

    public static void main(String[] args) {


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://localhost:8080/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final BooksService booksService = retrofit.create(BooksService.class);
        final SurveyPushService surveyPushService = retrofit.create(SurveyPushService.class);
/*
        int term_day = Integer.parseInt(System.getenv("TERM_DAY"));
        int term_hour = Integer.parseInt(System.getenv("TERM_HOUR"));
*/


        int term_day = 5;
        int term_hour = 5;

        Call<List<Book>> call = booksService.listBooks(LocalDateTime.now().minusDays(term_day));

        call.enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                Call<Void> pushCall = surveyPushService.pushSurvey(response.body());
                try {
                    pushCall.execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {

            }
        });
    }
}
