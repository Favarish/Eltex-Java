package ru.eltex;


import lombok.Getter;
import lombok.Setter;

public abstract class User {
    @Getter @Setter
    private Integer id;
    @Getter @Setter
    private String name;
    @Getter @Setter
    private Short age;
    @Getter @Setter
    private String phone;

    public User(Integer id, String name, Short age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    public User(Integer id, String name, Short age, String phone) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
    }
}
