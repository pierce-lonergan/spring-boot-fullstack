package com.example.demo.reviews;

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
@Table(name="reviews")
public class Reviews {

    @Id // This is an interface
    @SequenceGenerator(
            name = "reviews_sequence",
            sequenceName = "reviews_sequence",
            allocationSize = 1
    ) //equivalent of saying big serial
    @GeneratedValue(
            generator = "reviews_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;
    private Integer booking_Id;
    private Integer rating;
    private String review;

    public Reviews(Integer booking_Id, Integer rating, String review) {
        this.booking_Id = booking_Id;
        this.rating = rating;
        this.review = review;
    }
}
