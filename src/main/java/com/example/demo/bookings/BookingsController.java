package com.example.demo.bookings;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/bookings")
@AllArgsConstructor
public class BookingsController {

    private final BookingsService bookingsService;

    @GetMapping
    public List<Bookings> getAllStudents() {
        List<Bookings> allBookings = bookingsService.getAllStudents();
        return allBookings;
    }

    @PostMapping
    public void addStudent(@RequestBody Bookings bookings){
        bookingsService.addStudent(bookings);
    }




}
