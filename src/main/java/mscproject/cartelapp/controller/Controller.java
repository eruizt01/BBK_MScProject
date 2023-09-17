package mscproject.cartelapp.controller;

import mscproject.cartelapp.DTO.EmailDTO;
import mscproject.cartelapp.DTO.PageRankDTO;
import mscproject.cartelapp.DTO.MessageDTO;
import mscproject.cartelapp.DTO.InteractionsDTO;
import mscproject.cartelapp.entity.Person;
import mscproject.cartelapp.repository.EmailRepository;
import mscproject.cartelapp.repository.MessageRepository;
import mscproject.cartelapp.repository.PersonRepository;
import mscproject.cartelapp.service.EmailService;
import mscproject.cartelapp.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;


@org.springframework.stereotype.Controller
public class Controller {

    //Add logging to the class
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    @Autowired
    private final PersonRepository personRepository;
    @Autowired
    private EmailRepository emailRepository;

    @Autowired
    private EmailService emailService;


    @Autowired
    private MessageService messageService;

    @Autowired
    private MessageRepository  messageRepository;

    @Autowired
    public Controller(PersonRepository personRepository, EmailRepository emailRepository, MessageRepository  messageRepository) {
        this.personRepository = personRepository;
        this.emailRepository = emailRepository;
        this.messageRepository = messageRepository;
    }

    // Mapping to display the "Create New Person" form
    @GetMapping("/")
    public String showPersonForm(Model model) {
        logger.info("showPersonForm method invoked");
        model.addAttribute("person", new Person());
        model.addAttribute("allPersons", personRepository.findAll());
        return "cartelApp";
    }

    // Mapping to handle form submission and create a new Person
    @PostMapping("/createPerson")
    public String createPerson(@ModelAttribute("person") Person person) {
        logger.info("createPerson method invoked with data: {}", person);
        personRepository.save(person);
        return "redirect:/";
    }

    // Mapping to delete a Person by ID
    @GetMapping("/deletePerson/{id}")
    public String deletePerson(@PathVariable("id") Long id) {
        logger.info("deletePerson method invoked for id: {}", id);
        personRepository.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/mostSentEmails")
    public String getPersonWithMostSentEmails(Model model) {
        List <EmailDTO> result = emailService.getPersonWithMostSentEmails();
        model.addAttribute("mostSentEmails", result);
        model.addAttribute("person", new Person());
        return "cartelApp";
    }

    @GetMapping("/mostReceivedEmails")
    public String getPersonWithMostReceivedEmails(Model model) {
        List <EmailDTO> result = emailService.getPersonWithMostReceivedEmails();
        model.addAttribute("mostReceivedEmails", result);
        model.addAttribute("person", new Person());
        return "cartelApp";
    }

    @GetMapping("/topEmailInteractions")
    public String getTopEmailInteractions(Model model) {
        List<InteractionsDTO> results = emailService.getTopEmailInteractions();
        model.addAttribute("topEmailInteractions", results);
        model.addAttribute("person", new Person());
        return "cartelApp";
    }


    @GetMapping("/top5PageRankedPersons")
    public String getTop5PageRankedPersons(Model model) {
        List<PageRankDTO> top5PageRankedPersons = emailService.getTop5PageRankedPersons();
        // Debugging line to print the list contents to the console
        System.out.println(top5PageRankedPersons);
        model.addAttribute("top5PageRankedPersons", top5PageRankedPersons);
        model.addAttribute("person", new Person());
        return "cartelApp";
    }


    @GetMapping("/mostSentMessages")
    public String getPersonWithMostSentMessages(Model model) {
        List<MessageDTO> result = messageService.getPersonWithMostSentMessages();
        model.addAttribute("mostSentMessages", result);
        model.addAttribute("person", new Person());
        return "cartelApp";
    }

    @GetMapping("/mostReceivedMessages")
    public String getPersonWithMostReceivedMessages(Model model) {
        List <MessageDTO> result = messageService.getPersonWithMostReceivedMessages();
        model.addAttribute("mostReceivedMessages", result);
        model.addAttribute("person", new Person());
        return "cartelApp";
    }



}

