package com.beta.informationservice.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Place {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long placeID;
    private String name;

    public long getPlaceID() {
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
