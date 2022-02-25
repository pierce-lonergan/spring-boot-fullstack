package com.example.demo.user;

import com.example.demo.bookings.Bookings;
import com.example.demo.places.Places;
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
@Table
public class User {

    @Id // This is an interface
    @SequenceGenerator(
            name = "user_sequence",
            sequenceName = "user_sequence",
            allocationSize = 1
    ) //equivalent of saying big serial
    @GeneratedValue(
            generator = "user_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;
    private String email;


    public User(String email) {
        this.email = email;

    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "place_Id", referencedColumnName = "id")
    private Bookings bookings;

//    @OneToOne(cascade = CascadeType.ALL)
//    @JoinColumn(name = "user_Id", referencedColumnName = "id")
//    private Hosts hosts;
}
