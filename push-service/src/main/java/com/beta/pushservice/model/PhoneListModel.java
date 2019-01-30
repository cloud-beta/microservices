package com.beta.pushservice.model;

import java.util.ArrayList;
import java.util.List;

public class PhoneListModel {
    private List<Book> phoneList = new ArrayList<Book>();

    public PhoneListModel(){}

    public PhoneListModel(ArrayList<Book> phoneList) {
        this.phoneList = phoneList;
    }

    public List<Book> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(ArrayList<Book> phoneList) {
        this.phoneList = phoneList;
    }
}
