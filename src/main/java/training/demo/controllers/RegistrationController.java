package training.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import training.demo.models.Roles;
import training.demo.models.allUsers;


import java.util.Collections;
import java.util.Map;

@Controller
public class RegistrationController {
@Autowired
    training.demo.repo.usersRepository usersRepository;

    @GetMapping ("/registration")
    public String registration(){
        return "/registration" ;
    }

    @PostMapping ("/registration")
    public String adduser (allUsers user, Map<String, Object>model) {
   usersRepository.findByUsername(user.getUsername());
    if (usersRepository.findByUsername(user.getUsername()) !=null){
        model.put("message", "Пользователь уже существует");
        return "registration";
    }
    user.setActive(true);
        user.setRoles(Collections.singleton(Roles.USER));
        usersRepository.save(user);

        return "redirect:/login";
    }
}
