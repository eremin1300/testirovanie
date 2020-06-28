package training.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import training.demo.models.themes;
import training.demo.models.video;

@Controller
public class adminController {

    @Autowired
    private training.demo.repo.videoRepository videoRepository;
    @Autowired
    private training.demo.repo.ThemesRepo ThemesRepo;

    @GetMapping("/adminroom")
    public String adminroom(Model model) {
        model.addAttribute("title", "Админка");
        return "/adminRoom";
    }

    @GetMapping("/addvideo")
    public String addvideo(Model model) {
        Iterable<themes> test = ThemesRepo.findAll();
        model.addAttribute("test", test);
        return "/addvideo";
    }

  /*  @ModelAttribute("allVideo")
    public List<video> allUsers() {
        List<User> userList= repo.findAll();
        return userList;
    }*/

    @GetMapping("/addlesson")
    public String addlesson(Model model) {
        Iterable<themes> test = ThemesRepo.findAll();
        model.addAttribute("test", test);
        return "/addlesson";
    }

    @GetMapping("/addtest")
    public String addtest(Model model) {
        Iterable<themes> test = ThemesRepo.findAll();
        model.addAttribute("test", test);
        return "/addtest";
    }

    @GetMapping("/addthemes")
    public String addth(Model model) {
        model.addAttribute("title", "Добавить тему");
        return "/addThemes";
    }

}