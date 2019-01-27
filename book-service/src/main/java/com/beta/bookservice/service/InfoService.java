package com.beta.bookservice.service;


import com.beta.informationservice.model.Place;
import org.springframework.data.repository.CrudRepository;

public interface InfoService extends CrudRepository<Place, Long> {

}
