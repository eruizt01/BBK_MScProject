package mscproject.cartelapp.controller;

import mscproject.cartelapp.entity.Person;
import mscproject.cartelapp.repository.PersonRepository;
import mscproject.cartelapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/cartelApp")
public class PersonController {

    private final PersonRepository personRepository;
    @Autowired
    private PersonService personService;

    @Autowired
    public PersonController(PersonRepository personRepository) {
        this.personRepository = personRepository;
        System.out.println("Controller Initialized");
    }

    // Updated method
    @GetMapping("/showPersonForm")
    public String showPersonForm(Model model) {
        model.addAttribute("person", new Person());
        model.addAttribute("allPersons", personRepository.findAll());  // Add this line to list all persons
        return "cartelAppForm"; //
    }


    // Handle form submission
    @PostMapping("/createPerson")
    public String createPerson(@ModelAttribute Person person) {
        Person savedPerson = personRepository.save(person);
        return "redirect:/cartelApp/showPersonForm";
    }


    @GetMapping("/deletePerson/{id}")
    public String deletePerson(@PathVariable Long id) {
        personService.deletePerson(id);
        return "redirect:/cartelApp/showPersonForm";
    }

    // In case we want an API endpoint to list all persons
    @GetMapping("/api/all")
    public List<Person> getAllPersons() {
        return personRepository.findAll();
    }


}
