package training.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import training.demo.models.lesson;
import training.demo.models.test;
import training.demo.models.themes;
import training.demo.models.video;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class editController {
    @Autowired
    private training.demo.repo.videoRepository videoRepository;
    @Autowired
    private training.demo.repo.ThemesRepo ThemesRepo;
    @Autowired
    private training.demo.repo.lessonRepository lessonRepository;
    @Autowired
    private training.demo.repo.testRepository testRepository;


    @GetMapping("/editvideo")
    public String editvideo(Model model) {
        Iterable<video> video = videoRepository.findAll();
        model.addAttribute("video", video);
        return "/editVideo";
    }

    @GetMapping("/editvideoform/{id}")
    public String videoedit(@PathVariable(value = "id") long videoid, Model model) {
        Optional<video> video = videoRepository.findById(videoid);
        ArrayList<video> vidos = new ArrayList<>();
        video.ifPresent(vidos::add);
        model.addAttribute("video", vidos);

        return "/editVideoForm";
    }

    @GetMapping("/editlesson")
    public String editlesson(Model model) {
        Iterable<lesson> lesson = lessonRepository.findAll();
        model.addAttribute("lesson", lesson);
        return "/EditLessons";
    }

    @GetMapping("/edittests")
    public String edittests(Model model) {
        Iterable<test> test = testRepository.findAll();
        model.addAttribute("test", test);
        return "/EditTests";
    }

    @GetMapping("/edittestsform/{id}")
    public String testedit(@PathVariable(value = "id") long testid, Model model) {
        Optional<test> testone = testRepository.findById(testid);
        ArrayList<test> testpoint = new ArrayList<>();
        testone.ifPresent(testpoint::add);
        model.addAttribute("test", testpoint);
        return "/editTestForm";
    }

    @GetMapping("/editlessonsform/{id}")
    public String lessonsedit(@PathVariable(value = "id") long lessonid, Model model) {
        Optional<lesson> lessonone = lessonRepository.findById(lessonid);
        ArrayList<lesson> lessonpoint = new ArrayList<>();
        lessonone.ifPresent(lessonpoint::add);
        model.addAttribute("lesson", lessonpoint);
        return "/editLessonsForm";
    }

    @GetMapping("/editthemes")
    public String editthemes(Model model) {
        Iterable<themes> themes = ThemesRepo.findAll();
        model.addAttribute("themes", themes);
        return "/editThemes";
    }

    @GetMapping("/editthemesform/{id}")
    public String ditthemesform(@PathVariable(value = "id") long themesid, Model model) {
        Optional<themes> themes = ThemesRepo.findById(themesid);
        ArrayList<themes> themespoint = new ArrayList<>();
        themes.ifPresent(themespoint::add);
        model.addAttribute("themes", themespoint);
        return "/editLessonsForm";
    }


}
