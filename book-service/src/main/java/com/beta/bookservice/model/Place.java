package com.beta.bookservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int placeID;
    private String name;

    public int getPlaceID() {
        return placeID;
    }

    public void setPlaceID(int placeID) {
        this.placeID = placeID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    protected Place() {}

    public Place(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format(
                "Restaurant[placeID=%d, name='%s']",
                placeID, name);
    }
}
