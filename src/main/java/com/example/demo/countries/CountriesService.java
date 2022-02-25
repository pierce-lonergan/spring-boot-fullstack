package com.example.demo.countries;
// anything that ends with the postfix Service contains
// the business logic

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CountriesService {

    private final CountriesRepository countriesRepository;

    public List<Countries> getAllStudents() { //ideally we would want to get pagination
        return countriesRepository.findAll();

    }

    public void addStudent(Countries countries) {
        // check if email is taken
        // if it is taken an error is thrown
        countriesRepository.save(countries);
    }
}
