package training.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import training.demo.models.lesson;
import training.demo.models.test;
import training.demo.models.video;
import training.demo.models.themes;


@Controller
public class PostController {
    @Autowired
    private training.demo.repo.videoRepository videoRepository;
    @Autowired
    private training.demo.repo.ThemesRepo ThemesRepo;
    @Autowired
    private training.demo.repo.lessonRepository lessonRepository;
    @Autowired
    private training.demo.repo.testRepository testRepository;


    @PostMapping("/addvideo")
    public String addVideoAdd(@RequestParam String name, @RequestParam String title, @RequestParam String URL, Model model) {
        video vidos = new video(name, title, URL);
        videoRepository.save(vidos);
        return "redirect:/videolist";
    }

    @PostMapping("/addlessons")
    public String addLessonsAdd(@RequestParam String theme, @RequestParam String title, @RequestParam String fulltext, Model model) {
        lesson lesson = new lesson(theme, title, fulltext);
        lessonRepository.save(lesson);
        return "redirect:/addlessons";
    }

    @PostMapping("/addtest")
    public String addtestAdd(@RequestParam String theme, @RequestParam String title, @RequestParam String num,@RequestParam String fulltext, Model model) {
        test test = new test(theme, title, num, fulltext);
        testRepository.save(test);
        return "redirect:/addtest";
    }

    @PostMapping("/editvideoform/{id}")
    public String editvideo(@PathVariable(value = "id") long id, @RequestParam String name, @RequestParam String title, @RequestParam String URL, Model model) {
        video vidos = videoRepository.findById(id).orElseThrow();
        vidos.setName(name);
        vidos.setTitle(title);
        vidos.setURL(URL);
        videoRepository.save(vidos);
        return "redirect:/editvideo";
    }

    @PostMapping("/addthemes")
    public String addTHadd(@RequestParam String name, Model model) {
        themes newTheme = new themes(name);
        ThemesRepo.save(newTheme);
        return "redirect:/th";
    }
}
