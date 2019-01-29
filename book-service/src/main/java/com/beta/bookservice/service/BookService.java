package com.beta.bookservice.service;

import com.beta.bookservice.model.Book;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface BookService extends CrudRepository<Book, Long> {

    @Query("select b from Book b where phone=:phone")
    List<Book> findByPhoneSQL(@Param("phone") int phone);

    @Query("select b from Book b where bookDate >= :bookDate")
    List<Book> findByBookDateAfterSQL(@Param("bookDate") LocalDateTime bookDate);

}
