package training.demo.controllers;

import org.hibernate.engine.jdbc.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import training.demo.models.lesson;
import training.demo.models.video;
import training.demo.models.test;
import java.util.ArrayList;

import static com.google.common.collect.Iterables.size;

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
    @GetMapping("/videolist/{name}")
    public String videowatch(@PathVariable(value = "name") String videoname, Model model) {

        Iterable<video> video = videoRepository.findByName(videoname);
         if(size(video)!=0) {
             ArrayList<video> vidos = new ArrayList<>();

             video.forEach(vidos::add);
             model.addAttribute("video", vidos);
         }
        else {
                model.addAttribute("message", "message");
             }
        return "videolist";
    }
    @GetMapping("/videolist/{name}/{id}")
    public String videowatchbyid(@PathVariable(value = "name") String  name, @PathVariable(value = "id") long videoid, String videoname, Model model) {
        Iterable<video> video = videoRepository.findByNameAndId(name ,videoid);
        ArrayList<video> vidos = new ArrayList<>();
        video.forEach(vidos::add);
        model.addAttribute("video", vidos);
        return "videoDetails";
    }

   /* @GetMapping("/videolist/{id}")
    public String videowatch(@PathVariable(value = "id") long videoid, Model model) {
        Optional<video> video = videoRepository.findById(videoid);
        ArrayList<video> vidos = new ArrayList<>();
        video.ifPresent(vidos::add);
        model.addAttribute("video", vidos);
        return "videoDetails";
    }
    @GetMapping("/videolist/{name}/{id}")
    public String videowatchtheme(@PathVariable(value = "id") long videoid,@PathVariable(value = "name") long themes, Model model) {
        Optional<video> video = videoRepository.findById(videoid);
        ArrayList<video> vidos = new ArrayList<>();
        video.ifPresent(vidos::add);
        model.addAttribute("video", vidos);
        return "videoDetails";
    }

    @GetMapping("/videolist/{th}")
    public String videowatchbythemes_id(@PathVariable(value = "th") long videoth, Model model) {
        Optional<video> video = videoRepository.findById(videoth);
        ArrayList<video> vidos = new ArrayList<>();
        video.ifPresent(vidos::add);
        model.addAttribute("video", vidos);
        return "videolist";
    }*/
}
