package com.example.demo.places;
// anything that ends with the postfix Service contains
// the business logic

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class PlacesService {

    private final PlacesRepository placesRepository;

    public List<Places> getAllStudents() { //ideally we would want to get pagination
        return placesRepository.findAll();

    }

    public void addStudent(Places places) {
        // check if email is taken
        // if it is taken an error is thrown
        placesRepository.save(places);
    }
}
