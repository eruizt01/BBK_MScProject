package mscproject.cartelapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/cartelApp")
public class MainController {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    // Endpoint to show the main cartelAppForm
    @GetMapping("/showCartelAppForm")
    public String showCartelAppForm(Model model) {
        // Optionally, set up any model attributes here
        return "cartelAppForm";
    }
}
