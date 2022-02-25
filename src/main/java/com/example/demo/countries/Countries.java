package com.example.demo.countries;

import com.example.demo.cities.Cities;
import com.example.demo.places.Places;
import lombok.*;

import javax.persistence.*;
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
@Table(name="countries")
public class Countries {

    @Id // This is an interface
    @SequenceGenerator(
            name = "countries_sequence",
            sequenceName = "countries_sequence",
            allocationSize = 1
    ) //equivalent of saying big serial
    @GeneratedValue(
            generator = "countries_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;
    private String name;
    private Integer country_Id;

    public Countries(String name, Integer country_Id) {
        this.name = name;
        this.country_Id = country_Id;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "country_Id", referencedColumnName = "id")
    private Cities cities;

}
