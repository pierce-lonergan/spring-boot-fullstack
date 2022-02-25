package com.example.demo.places;

import com.example.demo.bookings.Bookings;
import com.example.demo.reviews.Reviews;
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
@Table(name="places")
public class Places {

    @Id // This is an interface
    @SequenceGenerator(
            name = "places_sequence",
            sequenceName = "places_sequence",
            allocationSize = 1
    ) //equivalent of saying big serial
    @GeneratedValue(
            generator = "places_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Integer Id;
    private Integer host_id;
    private String address;
    private Integer city_id;

    public Places(Integer host_id, String address, Integer city_id) {
        this.host_id = host_id;
        this.address = address;
        this.city_id = city_id;
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "place_Id", referencedColumnName = "id")
    private Bookings bookings;

}
