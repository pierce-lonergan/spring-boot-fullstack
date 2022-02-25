package com.example.demo.bookings;
// anything that ends with the postfix Service contains
// the business logic

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class BookingsService {

    private final BookingsRepository bookingsRepository;

    public List<Bookings> getAllStudents() { //ideally we would want to get pagination
        return bookingsRepository.findAll();

    }

    public void addStudent(Bookings bookings) {
        // check if email is taken
        // if it is taken an error is thrown
        bookingsRepository.save(bookings);
    }
}
