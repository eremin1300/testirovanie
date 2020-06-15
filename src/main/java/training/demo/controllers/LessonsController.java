package training.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import training.demo.models.lesson;
import training.demo.models.video;
import training.demo.models.test;
import training.demo.repo.lessonRepository;
import training.demo.repo.videoRepository;
import training.demo.repo.testRepository;

@Controller
public class LessonsController {



    @Autowired
    private training.demo.repo.lessonRepository lessonRepository;
    @Autowired
    private training.demo.repo.videoRepository videoRepository;
    @Autowired
    private training.demo.repo.testRepository testRepository;

    @GetMapping("/videolist")
    public String video(Model model) {
        model.addAttribute("title", "Видео");
        Iterable<video> video = videoRepository.findAll();
        model.addAttribute("video", video);
        return "videoList";
    }
    @GetMapping("/lessonslist")
    public String lesson(Model model) {
        model.addAttribute("title", "Статьи");
        Iterable<lesson> lesson = lessonRepository.findAll();
        model.addAttribute("lesson", lesson);
        return "LessonsList";
    }
    @GetMapping("/testlist")
    public String tests(Model model) {
        model.addAttribute("title", "Тесты");
        Iterable<test> test = testRepository.findAll();
        model.addAttribute("test", test);
        return "TestList";
    }

}
