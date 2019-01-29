package com.beta.bookservice.model;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int bookID;

    private String phone;

    private LocalDateTime bookDate;

    private int placeID;

    public Book(){

    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public LocalDateTime getBookDate() {
        return bookDate;
    }

    public void setBookDate(LocalDateTime bookDate) {
        this.bookDate = bookDate;
    }

    public int getPlaceID() {
        return placeID;
    }

    public void setPlaceID(int placeID) {
        this.placeID = placeID;
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookID=" + bookID +
                ", phone=" + phone +
                ", bookDate=" + bookDate +
                ", placeID=" + placeID +
                '}';
    }
}
