package com.beta.bookservice.model;

import java.time.LocalDateTime;

public class BookDateCondition {

    private LocalDateTime afterCondition;

    public BookDateCondition(){

    }

    public LocalDateTime getAfterCondition() {
        return afterCondition;
    }

    public void setAfterCondition(LocalDateTime afterCondition) {
        this.afterCondition = afterCondition;
    }
}
