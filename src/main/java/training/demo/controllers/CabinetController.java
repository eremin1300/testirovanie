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

    @GetMapping("/cabinet")
    public String cabinet(Model model) {
        Iterable<posts> posts = postRepository.findAll();
        model.addAttribute("posts", posts);
        return "cabinet";
    }
    @GetMapping("/adminroom")
    public String cabinet(Model model) {
        model.addAttribute("title", "Главная страница");
        return "adminRoom";
    }

}
