package service;

import model.Book;
import retrofit2.Call;
import retrofit2.http.*;

import java.time.LocalDateTime;
import java.util.List;

public interface BooksService {

    @Headers("Accept: application/json")
    @GET("/books/")
    Call<List<Book>> listBooks(@Query("afterCondition") LocalDateTime afterCondition);

}
