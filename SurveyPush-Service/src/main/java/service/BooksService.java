package service;

import model.Books;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.Map;

public interface BooksService {

    @GET("books/phone/")
    Call<Books> listBooks();

}
