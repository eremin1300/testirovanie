package training.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import training.demo.models.posts;
import training.demo.repo.postRepository;

@Controller
public class CabinetController {
    @Autowired
    private training.demo.repo.postRepository postRepository;


    @GetMapping("/adminroom")
    public String adminroom(Model model) {
        model.addAttribute("title", "Админка");
        return "adminRoom";
    }

}
