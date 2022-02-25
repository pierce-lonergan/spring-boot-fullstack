package com.example.demo.hosts;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/countries")
@AllArgsConstructor
public class HostsController {

    private final HostsService hostsService;

    @GetMapping
    public List<Hosts> getAllStudents() {
        List<Hosts> allBookings = hostsService.getAllStudents();
        return allBookings;
    }

    @PostMapping
    public void addStudent(@RequestBody Hosts hosts){
        hostsService.addStudent(hosts);
    }




}
