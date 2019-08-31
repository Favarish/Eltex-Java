package ru.eltex;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.LinkedList;

@RestController
public class UserController {
    @RequestMapping("/get_users")
    public LinkedList<User> getUser() {
        LinkedList<User> list = new LinkedList<>();
        list.add(new User(3, "Kory", "555"));
        list.add(new User(4, "Teilor", "666"));
        return list;
    }

    @RequestMapping("/sendQuery/{id}/{fio}")
    public User getUser1(@PathVariable("id") Integer id, @PathVariable("fio") String fio) {
        System.out.println("Вот что пришло с веба: " + id + " " + fio);
        return new User(1, "Koks", "456798132");
    }

    @RequestMapping("get_information")
    public LinkedList<User> getUsers() {
        LinkedList<User> list = new LinkedList<>();
        list.add(new User(3, "Kory", "555"));
        list.add(new User(4, "Teilor", "666"));
        list.add(new User(5, "Penny", "222"));

        return list;
    }
}