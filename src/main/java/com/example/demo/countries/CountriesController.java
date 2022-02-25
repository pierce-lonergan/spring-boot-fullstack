package com.example.demo.countries;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/countries")
@AllArgsConstructor
public class CountriesController {

    private final CountriesService countriesService;

    @GetMapping
    public List<Countries> getAllStudents() {
        List<Countries> allBookings = countriesService.getAllStudents();
        return allBookings;
    }

    @PostMapping
    public void addStudent(@RequestBody Countries countries){
        countriesService.addStudent(countries);
    }




}
