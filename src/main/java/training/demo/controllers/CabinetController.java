package training.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class CabinetController {
    @GetMapping("/cabinet")
    public String cabinet(Model model) {
        return "cabinet";
    }
}
