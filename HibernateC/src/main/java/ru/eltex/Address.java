package ru.eltex;

import lombok.*;
import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "address")
@lombok.Setter
@lombok.Getter
@AllArgsConstructor
@NoArgsConstructor
class Address {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String city;
    private String street;
    private String building;

    public Address(String city, String street, String building) {
        this.city = city;
        this.street = street;
        this.building = building;
    }

    @OneToMany(mappedBy = "address", fetch = FetchType.EAGER)
    private Collection <User> owner;
}