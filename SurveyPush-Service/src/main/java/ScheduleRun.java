import model.Book;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import service.BooksService;
import service.SurveyPushService;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.List;

public class ScheduleRun {

    public static void main(String[] args) {

        Retrofit bookServiceRetrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.0.10:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        Retrofit pushServiceRetrofit = new Retrofit.Builder()
                .baseUrl("http://10.0.0.10:8083/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        final BooksService booksService = bookServiceRetrofit.create(BooksService.class);
        final SurveyPushService surveyPushService = pushServiceRetrofit.create(SurveyPushService.class);
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
                /*
                Call<Void> pushCall = surveyPushService.pushSurvey(response.body());
                try {
                    pushCall.execute();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                */
                System.out.println(response.toString());
                Call<Void> pushCall = surveyPushService.pushSurvey(response.body());
                pushCall.enqueue(new Callback<Void>() {
                    @Override
                    public void onResponse(Call<Void> call, Response<Void> response) {
                        System.out.println(response.toString());
                    }

                    @Override
                    public void onFailure(Call<Void> call, Throwable t) {
                        System.out.println(t.toString());
                    }
                });
            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                System.out.println(t.toString());
            }
        });
    }
}
