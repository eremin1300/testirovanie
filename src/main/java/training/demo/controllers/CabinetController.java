package training.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CabinetController {


    @GetMapping("/cabinet")
    public String cabinet(Model model) {
        model.addAttribute("title", "Личный Кабинет");
        return "cabinet";
    }


    @GetMapping("/editTh")
    public String editTh(Model model) {
        model.addAttribute("title", "Релактировать темы");
        return "editThemes";
    }

    @GetMapping("/th")
    public String th(Model model) {
        model.addAttribute("title", "Список Тем");
        return "Themes";
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
