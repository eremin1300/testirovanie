package training.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainWebController {

    @GetMapping("/")
    public String home1(Model model) {
        model.addAttribute("title", "Главная страница");
        return "/cabinet";
    }

}