package com.beta.informationservice.service;


import com.beta.informationservice.model.Place;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface InfoService extends CrudRepository<Place, Long> {

}
