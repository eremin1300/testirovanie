package training.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import training.demo.models.video;

import java.util.ArrayList;
import java.util.Optional;


@Controller
public class adminController {

    @Autowired
    private training.demo.repo.videoRepository videoRepository;

    @GetMapping("/adminroom")
    public String adminroom(Model model) {
        model.addAttribute("title", "Админка");
        return "adminRoom";
    }

    @GetMapping("/addvideo")
    public String addvideo(Model model) {
        model.addAttribute("title", "Добавить Видео");
        return "addvideo";
    }

    @GetMapping("/addtest")
    public String addtest(Model model) {
        model.addAttribute("title", "Добавить Тесты");
        return "addtest";
    }

    @GetMapping("/addlesson")
    public String addlesson(Model model) {
        model.addAttribute("title", "Добавить Статьи");
        return "addlesson";
    }

    @PostMapping("/addvideo")
    public String addVideoAdd(@RequestParam String name, @RequestParam String title, @RequestParam String URL, Model model) {
        video vidos = new video(name, title, URL);
        vidos = videoRepository.save(vidos);
        return "redirect:/videolist";
    }
    @GetMapping("/videolist/{id}")
    public String videowatch(@PathVariable(value = "id") long videoid, Model model) {
     Optional<video> video = videoRepository.findById(videoid);
        ArrayList<video> vidos = new ArrayList<>();
        video.ifPresent(vidos::add);
        model.addAttribute("vidos", vidos);
        return "videoDetails";
    }
}