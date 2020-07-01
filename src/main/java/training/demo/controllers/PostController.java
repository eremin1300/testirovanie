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

    @PostMapping("/editvideoform/{id}")
    public String editvideo(@PathVariable(value = "id") long id, @RequestParam String name, @RequestParam String title, @RequestParam String URL, Model model) {
        video vidos = videoRepository.findById(id).orElseThrow();
        vidos.setName(name);
        vidos.setTitle(title);
        vidos.setURL(URL);
        videoRepository.save(vidos);
        return "redirect:/editvideo";
    }

    @PostMapping("/addlesson")
    public String addLessonsAdd(@RequestParam String name, @RequestParam String title, @RequestParam String fulltext, Model model) {
        lesson lesson = new lesson(name, title, fulltext);
        lessonRepository.save(lesson);
        return "redirect:/addlesson";
    }

    @PostMapping("/editlessonsform/{id}")
    public String editlessonsform(@PathVariable(value = "id") long id, @RequestParam String name, @RequestParam String title, @RequestParam String fullText, Model model) {
        lesson lesson = lessonRepository.findById(id).orElseThrow();
        lesson.setName(name);
        lesson.setTitle(title);
        lesson.setFullText(fullText);
        lessonRepository.save(lesson);
        return "redirect:/editlesson";
    }

    @PostMapping("/addtest")
    public String addtestAdd(@RequestParam String name, @RequestParam String title, @RequestParam String num,@RequestParam String fulltext, Model model) {
        test test = new test(name, title, num, fulltext);
        testRepository.save(test);
        return "redirect:/addtest";
    }

    @PostMapping("/edittestsform/{id}")
    public String edittestform(@PathVariable(value = "id") long id, @RequestParam String name, @RequestParam String title, @RequestParam String fullText,@RequestParam String num, Model model) {
        test test = testRepository.findById(id).orElseThrow();
        test.setName(name);
        test.setTitle(title);
        test.setNum(num);
        test.setFullText(fullText);
        testRepository.save(test);
        return "redirect:/edittests";
    }

    @PostMapping("/addthemes")
    public String addTHadd(@RequestParam String name, Model model) {
        themes newTheme = new themes(name);
        ThemesRepo.save(newTheme);
        return "redirect:/th";
    }
}
