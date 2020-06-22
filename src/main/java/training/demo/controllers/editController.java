package training.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import training.demo.models.video;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class editController {
    @Autowired
    private training.demo.repo.videoRepository videoRepository;

    @GetMapping("/editvideo")
    public String editvideo(Model model) {
        model.addAttribute("title", "Редактировать видео");
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
    public String aeditlesson(Model model) {
        model.addAttribute("title", "Добавить Статьи");
        return "/lessonslist";
    }

    @GetMapping("/edittests")
    public String edittests(Model model) {
        model.addAttribute("title", "Добавить Статьи");
        return "/testlist";
    }


}
