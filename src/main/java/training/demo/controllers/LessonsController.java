package training.demo.controllers;

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
        Iterable<video> video = videoRepository.findAll();
        model.addAttribute("video", video);
        return "videoList";
    }

    @GetMapping("/lessonlist")
    public String lesson(Model model) {
        Iterable<lesson> lesson = lessonRepository.findAll();
        model.addAttribute("lesson", lesson);
        return "LessonsList";
    }

    @GetMapping("/testlist")
    public String tests(Model model) {
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

    @GetMapping("/testlist/{name}")
    public String testwatch(@PathVariable(value = "name") String testname, Model model) {

        Iterable<test> test = testRepository.findByName(testname);
        if(size(test)!=0) {
            ArrayList<test> testpoint = new ArrayList<>();

            test.forEach(testpoint::add);
            model.addAttribute("test", testpoint);
        }
        else {
            model.addAttribute("message", "message");
        }
        return "testlist";
    }

    @GetMapping("/testlist/{name}/{id}")
    public String testwatchbyid(@PathVariable(value = "name") String  name, @PathVariable(value = "id") long testid, String testname, Model model) {
        Iterable<test> test = testRepository.findByNameAndId(name ,testid);
        ArrayList<test> testpoint = new ArrayList<>();
        test.forEach(testpoint::add);
        model.addAttribute("test", testpoint);
        return "TestDetails";
    }

    @GetMapping("/lessonlist/{name}")
    public String lessonwatch(@PathVariable(value = "name") String lessonname, Model model) {

        Iterable<lesson> lesson = lessonRepository.findByName(lessonname);
        if(size(lesson)!=0) {
            ArrayList<lesson> lessonpoint = new ArrayList<>();

            lesson.forEach(lessonpoint::add);
            model.addAttribute("lesson", lessonpoint);
        }
        else {
            model.addAttribute("message", "message");
        }
        return "LessonsList";
    }

    @GetMapping("/lessonlist/{name}/{id}")
    public String lessonwatchbyid(@PathVariable(value = "name") String  name, @PathVariable(value = "id") long lessonid, String lessonname, Model model) {
        Iterable<lesson> lesson = lessonRepository.findByNameAndId(name ,lessonid);
        ArrayList<lesson> lessonpoint = new ArrayList<>();
        lesson.forEach(lessonpoint::add);
        model.addAttribute("lesson", lessonpoint);
        return "LessonDetails";
    }


}
