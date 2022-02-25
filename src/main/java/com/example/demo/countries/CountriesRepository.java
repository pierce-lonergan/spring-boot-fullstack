package com.example.demo.countries;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

//JpaRepository<U,T> U has to be the object that models the table within the database
// T has to be equal to the data type of the primary key of the table.
@Repository
public interface CountriesRepository extends JpaRepository<Countries, Integer> {

}
