package com.example.demo.bookings;

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
@Table(name ="bookings")
public class Bookings {

    @Id // This is an interface
    @SequenceGenerator(
            name = "bookings_sequence",
            sequenceName = "bookings_sequence",
            allocationSize = 1
    ) //equivalent of saying big serial
    @GeneratedValue(
            generator = "bookings_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;
    private Integer user_Id;
    private Integer place_Id;
    private LocalDate start_Data;
    private LocalDate end_Data;
    private float price_Per_Night;

    public Bookings(LocalDate start_Data, LocalDate end_Data, float price_Per_Night) {
        this.start_Data = start_Data;
        this.end_Data = end_Data;
        this.price_Per_Night = price_Per_Night;
    }
    @Transient
    private Integer num_Nights;

    public Integer getNum_Nights() {
        return Period.between(this.start_Data, this.end_Data).getDays();
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "booking_id", referencedColumnName = "id")
    private Reviews reviews;
}
