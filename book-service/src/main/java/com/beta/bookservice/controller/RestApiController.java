package com.beta.bookservice.controller;

import com.beta.bookservice.model.Book;
import com.beta.bookservice.service.BookService;
import com.beta.bookservice.util.CustomErrorType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class RestApiController {

    public static final Logger logger = LoggerFactory.getLogger(RestApiController.class);

    @Autowired
    BookService bookService; //Service which will do all data retrieval/manipulation work

    // -------------------Retrieve All Users---------------------------------------------

    private final static class BookData{

        private String phone;
        private int placeID;

        public BookData() {
        }

        public BookData(String phone, int placeID) {
            this.phone = phone;
            this.placeID = placeID;
        }

        public int getPlaceID() {
            return placeID;
        }

        public void setPlaceID(int placeID) {
            this.placeID = placeID;
        }

        public String getPhone() {
            return phone;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

    }

    @RequestMapping(value = "/books/", method = RequestMethod.GET)
    public ResponseEntity<List<BookData>> listAllUsers(@RequestParam(value = "afterCondition") String bookDateCondition) {

        List<BookData> books = new ArrayList<>();

        for (Book book : bookService.findByBookDateAfterSQL(LocalDateTime.parse(bookDateCondition)
        )) {
            books.add(new BookData(book.getPhone(), book.getPlaceID()));
        }

        if (books.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
            // You many decide to return HttpStatus.NOT_FOUND
        }
        return new ResponseEntity<List<BookData>>(books, HttpStatus.OK);
    }

    @RequestMapping(value = "/book/", method = RequestMethod.GET)
    public ResponseEntity<List<Book>> getBook(@RequestParam(value = "phone") String phone) {
        logger.info("Fetching Book with id {}", phone);

        List<Book> books = bookService.findByPhoneSQL(Integer.parseInt(phone));

        if (books == null) {
            logger.error("Book with id {} not found.", phone);
            return new ResponseEntity(new CustomErrorType("Book with id " + phone
                    + " not found"), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<List<Book>>(books, HttpStatus.OK);
    }

    @RequestMapping(value = "/book/", method = RequestMethod.POST)
    public ResponseEntity<?> createBook(@RequestBody Book book) {
        logger.info("Creating Book : {}", book);
        bookService.save(book);
        return new ResponseEntity<String>(HttpStatus.CREATED);
    }

}