package com.beta.surveyservice;

import java.util.List;

import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;

@EnableScan
public interface CustomerRepository extends CrudRepository<Customer, String> {

    List<Customer> findByLastName(String lastName);
}