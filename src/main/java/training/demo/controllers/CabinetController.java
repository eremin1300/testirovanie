package training.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import training.demo.models.themes;

import java.util.ArrayList;
import java.util.Optional;

@Controller
public class CabinetController {

    @Autowired
    private training.demo.repo.ThemesRepo ThemesRepo;
    @Autowired
    private training.demo.repo.videoRepository videoRepository;

    @GetMapping("/cabinet")
    public String cabinet(Model model) {
        return "cabinet";
    }


    @GetMapping("/editTh")
    public String editTh(Model model) {
        return "editThemes";
    }

    @GetMapping("/th")
    public String theme(Model model) {
        Iterable<themes> themes = ThemesRepo.findAll();
        model.addAttribute("themes", themes);
        return "Themes";
    }

    @GetMapping("/th/{id}")
    public String videowatchthemes(@PathVariable(value = "id") long videoid, Model model) {
        Optional<themes> themes = ThemesRepo.findById(videoid);
        ArrayList<themes> themes2 = new ArrayList<>();
        themes.ifPresent(themes2::add);
        model.addAttribute("themes", themes2);
        return "videoDetails";
    }

    @GetMapping("/results")
    public String results(Model model) {
        model.addAttribute("title", "результаты");
        return "/results";
    }

    @GetMapping("/thv/{id}")
    public String themesVideoDetails(@PathVariable(value = "id") long videoid, Model model) {
        Optional<themes> themes = ThemesRepo.findById(videoid);
        ArrayList<themes> themes2 = new ArrayList<>();
        themes.ifPresent(themes2::add);
        model.addAttribute("themes", themes2);
        return "videolist";
    }

    @GetMapping("/thv")
    public String themesVideo(Model model) {
        Iterable<themes> themes = ThemesRepo.findAll();
        model.addAttribute("themes", themes);
        return "ThemesVideo";
    }

    @GetMapping("/tht")
    public String themesTest(Model model) {
        Iterable<themes> themes = ThemesRepo.findAll();
        model.addAttribute("themes", themes);
        return "ThemesTest";
    }

    @GetMapping("/tht/{id}")
    public String themesTestDetails(@PathVariable(value = "id") long testid, Model model) {
        Optional<themes> themes = ThemesRepo.findById(testid);
        ArrayList<themes> themes2 = new ArrayList<>();
        themes.ifPresent(themes2::add);
        model.addAttribute("themes", themes2);
        return "TestList";
    }

    @GetMapping("/thl")
    public String themesLessons(Model model) {
        Iterable<themes> themes = ThemesRepo.findAll();
        model.addAttribute("themes", themes);
        return "ThemesLessons";
    }

    @GetMapping("/thl/{id}")
    public String themesLessonsDetails(@PathVariable(value = "id") long lessonid, Model model) {
        Optional<themes> themes = ThemesRepo.findById(lessonid);
        ArrayList<themes> themes2 = new ArrayList<>();
        themes.ifPresent(themes2::add);
        model.addAttribute("themes", themes2);
        return "LessonList";
    }

}

/*
@Controller
@PreAuthorize("hasRole('Admin')")
@RequestMapping("/admin")
public class AdminController {
    @Transactional
    @PreAuthorize("hasRole('ADMIN')")
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public String checkPersonInfo(@ModelAttribute User user, Model model, Authentication authentication) {
        // user does not have the selected institution set
        customUserDetailsService.createNewUser(user);
        updateModelWithAllUsers(model);
        return "admin";
    }

    private void updateModelWithAllUsers(Model model) {
        model.addAttribute(USERLIST, customUserDetailsService.findAllUsers());
        model.addAttribute(INSTITUTION_LIST, institutionService.findAll());
        model.addAttribute("user", new User());
    }

...
}   */
