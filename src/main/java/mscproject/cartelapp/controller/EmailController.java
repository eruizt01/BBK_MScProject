package mscproject.cartelapp.controller;

import mscproject.cartelapp.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

@Controller
@RequestMapping("/cartelApp")
public class EmailController {

    @Autowired
    private EmailService emailService;

    @GetMapping("/mostSent")
    public String mostSentEmails(Model model) {
        model.addAttribute("mostSent", emailService.getPersonWithMostSentEmails());
        return "yourThymeleafTemplateForMostSent"; //replace with your Thymeleaf template
    }

    @GetMapping("/mostReceived")
    public String mostReceivedEmails(Model model) {
        model.addAttribute("mostReceived", emailService.getPersonWithMostReceivedEmails());
        return "yourThymeleafTemplateForMostReceived"; //replace with your Thymeleaf template
    }

    @GetMapping("/topInteractions")
    public String topEmailInteractions(Model model) {
        model.addAttribute("topInteractions", emailService.getTopEmailInteractions());
        return "yourThymeleafTemplateForTopInteractions"; //replace with your Thymeleaf template
    }
}

