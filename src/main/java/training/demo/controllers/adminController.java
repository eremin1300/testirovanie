package training.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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

    @GetMapping("/editvideo")
    public String editvideo(Model model) {
        model.addAttribute("title", "Добавить Статьи");
        return "editVideo";
    }

    @GetMapping("/addlesson")
    public String addlesson(Model model) {
        model.addAttribute("title", "Добавить Статьи");
        return "addlesson";
    }

    @GetMapping("/editlesson")
    public String aeditlesson(Model model) {
        model.addAttribute("title", "Добавить Статьи");
        return "editLesson";
    }

    @GetMapping("/addtest")
    public String addtest(Model model) {
        model.addAttribute("title", "Добавить Тесты");
        return "addtest";
    }

    @GetMapping("/edittests")
    public String edittests(Model model) {
        model.addAttribute("title", "Добавить Статьи");
        return "editTests";
    }



}