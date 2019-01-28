package com.beta.pushservice.model;

import java.util.ArrayList;

public class PhoneListModel {
    private ArrayList<String> phoneList = new ArrayList<String>();

    public PhoneListModel(){}

    public PhoneListModel(ArrayList<String> phoneList) {
        this.phoneList = phoneList;
    }

    public ArrayList<String> getPhoneList() {
        return phoneList;
    }

    public void setPhoneList(ArrayList<String> phoneList) {
        this.phoneList = phoneList;
    }
}
