package ru.eltex;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class WebController {
    @RequestMapping("/")
    public String index(Model model) {

        model.addAttribute("name", "Boris");
        model.addAttribute("user", new User(1, "Boris", "900"));
        model.addAttribute("cating", "Barsik");
        model.addAttribute("number", Math.random() * 10);
        return "index";
    }

    @RequestMapping("/getGet")
    public String index2(Model model) {
        return "index2";
    }
}
