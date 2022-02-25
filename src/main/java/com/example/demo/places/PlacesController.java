package com.example.demo.places;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/countries")
@AllArgsConstructor
public class PlacesController {

    private final PlacesService placesService;

    @GetMapping
    public List<Places> getAllStudents() {
        List<Places> allBookings = placesService.getAllStudents();
        return allBookings;
    }

    @PostMapping
    public void addStudent(@RequestBody Places places){
        placesService.addStudent(places);
    }




}
