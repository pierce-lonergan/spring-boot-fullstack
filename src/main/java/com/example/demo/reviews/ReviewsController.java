package com.example.demo.reviews;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/reviews")
@AllArgsConstructor
public class ReviewsController {

    private final ReviewsService reviewsService;

    @GetMapping
    public List<Reviews> getAllStudents() {
        List<Reviews> allBookings = reviewsService.getAllStudents();
        return allBookings;
    }

    @PostMapping
    public void addStudent(@RequestBody Reviews reviews){
        reviewsService.addStudent(reviews);
    }

}
