package ru.eltex;



import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@lombok.Setter
@lombok.Getter
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private int id;
    private String fio;
    private String phone;

    public User(String fio, String phone) {
        this.fio = fio;
        this.phone = phone;
    }
}