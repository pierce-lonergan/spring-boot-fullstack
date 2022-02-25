package com.example.demo.hosts;
// anything that ends with the postfix Service contains
// the business logic

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@AllArgsConstructor
@Service
public class HostsService {

    private final HostsRepository hostsRepository;

    public List<Hosts> getAllStudents() { //ideally we would want to get pagination
        return hostsRepository.findAll();

    }

    public void addStudent(Hosts hosts) {
        // check if email is taken
        // if it is taken an error is thrown
        hostsRepository.save(hosts);
    }
}
