package com.example.demo.hosts;

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
@Table(name="hosts")
public class Hosts {

    @Id // This is an interface
    @SequenceGenerator(
            name = "hosts_sequence",
            sequenceName = "hosts_sequence",
            allocationSize = 1
    ) //equivalent of saying big serial
    @GeneratedValue(
            generator = "hosts_sequence",
            strategy = GenerationType.SEQUENCE
    )
    private Integer id;
    private Integer user_Id;

    public Hosts(Integer country_Id) {
        this.user_Id = user_Id;
    }


    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "host_Id", referencedColumnName = "id")
    private Places places;

}
