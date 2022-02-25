package com.example.demo.cities;

import com.example.demo.places.Places;
import com.example.demo.reviews.Reviews;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.Period;
//@Data would cover all the annotations below except
// the fields would have to be immutable (final) which
// we can not do right now.

@ToString
@Getter
@Setter
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="cities")
public class Cities {

    @Id // This is an interface
    @SequenceGenerator(
            name = "cities_sequence",
            sequenceName = "cities_sequence",
            allocationSize = 1
    ) //equivalent of saying big serial
    @GeneratedValue(
            generator = "cities_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;
    private String name;
    private Integer country_Id;

    public Cities(String name, Integer country_Id) {
        this.name = name;
        this.country_Id = country_Id;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "city_Id", referencedColumnName = "id")
    private Places places;
}
