package training.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import training.demo.models.video;

@Controller
public class PostController {
    @Autowired
    private training.demo.repo.videoRepository videoRepository;

    @PostMapping("/addvideo")
    public String addVideoAdd(@RequestParam String name, @RequestParam String title, @RequestParam String URL, Model model) {
        video vidos = new video(name, title, URL);
        vidos = videoRepository.save(vidos);
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
}
