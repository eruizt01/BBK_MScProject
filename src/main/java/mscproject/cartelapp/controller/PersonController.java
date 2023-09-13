package mscproject.cartelapp.controller;

import mscproject.cartelapp.entity.Person;
import mscproject.cartelapp.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("/cartelApp")
public class PersonController {

    //Add logging to the class
    private static final Logger logger = LoggerFactory.getLogger(PersonController.class);
    private final PersonRepository personRepository;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    // Mapping to display the "Create New Person" form
    @GetMapping("/showPersonForm")
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
        return "redirect:/cartelApp/showPersonForm";
    }

    // Mapping to delete a Person by ID
    @GetMapping("/deletePerson/{id}")
    public String deletePerson(@PathVariable("id") Long id) {
        logger.info("deletePerson method invoked for id: {}", id);
        personRepository.deleteById(id);
        return "redirect:/cartelApp/showPersonForm";
    }
}
