package training.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.cdi.Eager;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import training.demo.repo.usersRepository;

@Controller
@RequestMapping("/users")
public class UsersController {
    @Autowired
    private usersRepository usersRepository;

    @GetMapping
    public String users (Model model) {
        model.addAttribute("users", usersRepository.findAll());

        return "userList";
    }
}
