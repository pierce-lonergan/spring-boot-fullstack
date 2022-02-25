package com.example.demo.reviews;
// anything that ends with the postfix Service contains
// the business logic

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class ReviewsService {

    private final ReviewsRepository reviewsRepository;

    public List<Reviews> getAllStudents() { //ideally we would want to get pagination
        return reviewsRepository.findAll();

    }

    public void addStudent(Reviews reviews) {
        reviewsRepository.save(reviews);
    }
}
