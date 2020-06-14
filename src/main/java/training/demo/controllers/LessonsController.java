package training.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import training.demo.models.posts;
@Controller
public class LessonsController {



    @Autowired
    private training.demo.repo.postRepository postRepository;

    @GetMapping("/videolist")
    public String video(Model model) {
        model.addAttribute("title", "Видео");
        return "videoList";
    }
    @GetMapping("/lessonslist")
    public String lesson(Model model) {
        model.addAttribute("title", "Статьи");
        return "LessonsList";
    }
    @GetMapping("/testlist")
    public String tests(Model model) {
        model.addAttribute("title", "Тесты");
        return "TestList";
    }

}
