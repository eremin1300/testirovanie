package training.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import training.demo.repo.postRepository;

@Controller
public class CabinetController {
    @Autowired
    private postRepository postRepository;


    @GetMapping("/cabinet")
    public String cabinet(Model model) {
        model.addAttribute("title", "Личный Кабинет");
        return "cabinet";
    }

}
