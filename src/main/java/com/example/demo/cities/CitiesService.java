package com.example.demo.cities;
// anything that ends with the postfix Service contains
// the business logic

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class CitiesService {

    private final CitiesRepository citiesRepository;

    public List<Cities> getAllStudents() { //ideally we would want to get pagination
        return citiesRepository.findAll();

    }

    public void addStudent(Cities cities) {
        // check if email is taken
        // if it is taken an error is thrown
        citiesRepository.save(cities);
    }
}
