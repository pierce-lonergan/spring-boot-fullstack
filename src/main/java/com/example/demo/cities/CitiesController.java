package com.example.demo.cities;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/cities")
@AllArgsConstructor
public class CitiesController {

    private final CitiesService citiesService;

    @GetMapping
    public List<Cities> getAllStudents() {
        List<Cities> allBookings = citiesService.getAllStudents();
        return allBookings;
    }

    @PostMapping
    public void addStudent(@RequestBody Cities cities){
        citiesService.addStudent(cities);
    }




}
