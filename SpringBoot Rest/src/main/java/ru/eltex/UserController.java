package ru.eltex;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
    @RequestMapping("/get_user")
    public String getUser() {
        //System.out.println(id);
        return "indexStr";
    }
    @RequestMapping("/get_user/{id}")
    public User getUser1(@PathVariable("id") Integer id) {
        System.out.println(id);
        return new User(1, "Koks", "456798132");
    }
}