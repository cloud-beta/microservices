package com.beta.pushservice.model;

import java.util.ArrayList;
import java.util.List;

public class PhoneListModel {
    private List<BookModel> phoneList = new ArrayList<BookModel>();

    public PhoneListModel(){}

    public PhoneListModel(ArrayList<BookModel> phoneList) {
        this.phoneList = phoneList;
    }

    public List<BookModel> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(ArrayList<BookModel> phoneList) {
        this.phoneList = phoneList;
    }
}
