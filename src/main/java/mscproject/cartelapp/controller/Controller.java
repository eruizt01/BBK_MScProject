package mscproject.cartelapp.controller;

import mscproject.cartelapp.DTO.*;
import mscproject.cartelapp.entity.Person;
import mscproject.cartelapp.service.EmailService;
import mscproject.cartelapp.service.MessageService;
import mscproject.cartelapp.service.PersonService;
import mscproject.cartelapp.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Controller Class
 * Responsible for handling interactions between frontend and backend of the CartelApp
 * @author eruizt01
 */


@org.springframework.stereotype.Controller
public class Controller {

    //Add logging to the class
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);
    @Autowired
    private final PersonService personService;

    @Autowired
    private EmailService emailService;


    @Autowired
    private MessageService messageService;

    @Autowired
    private ProductService productService;

    /**
     * Constructor for the Controller class
     * @param personService
     * @param emailService
     * @param messageService
     * @param productService
     */

    @Autowired
    public Controller( PersonService personService, EmailService emailService, MessageService messageService,
                       ProductService productService) {
        this.personService = personService;
        this.emailService = emailService;
        this.messageService = messageService;
        this.productService = productService;
    }

    /**
     *  Handle a GET request to the main page of the CartelApp to
     *  show the list of Persons and the form to create a new Person
     * @param model placeholder to populate the HTML template
     * @return String- representing the view to be displayed (cartelApp.html)
     */

    @GetMapping("/")
    public String showPersonForm(Model model) {
        logger.info("showPersonForm method invoked");
        model.addAttribute("person", new PersonDTO()); // Using DTO here
        model.addAttribute("allPersons", personService.findAll());
        return "cartelApp";
    }

    /**
     *  Handle creation of a new Person by listening to a POST request
     *  at the "createPerson" URL endpoint.
     * @param personDto - DTO containing the data of the new Person
     * @return String - URL to redirect to the view (cartelApp.html)
     */

    @PostMapping("/createPerson")
    public String createPerson(@ModelAttribute("person") PersonDTO personDto) {
        logger.info("createPerson method invoked with data: {}", personDto);

        Person person = new Person();
        person.setName(personDto.getName());
        person.setSurname(personDto.getSurname());
        person.setAge(personDto.getAge());
        person.setRole(personDto.getRole());
        person.setEmail_account(personDto.getEmail_account());
        person.setPhone_number(personDto.getPhone_number());
        personService.save(person);

        return "redirect:/";
    }

    /**
     * Handle a GET request to delete a Person by listening to a DELETE request
     * @param id - Long representing the ID of the Person to be deleted, this is
     *           an generated value by the database duly annotated in the entity class
     * @return redirect to the view (cartelApp.html)
     */

    @GetMapping("/deletePerson/{id}")
    public String deletePerson(@PathVariable("id") Long id) {
        logger.info("deletePerson method invoked for id: {}", id);
        personService.deleteById(id);
        return "redirect:/";
    }

    /**
     * Handle a GET request to get the List of Persons with most sent Emails
     * @param model placeholder to populate the HTML template
     *              with the list of Persons with most sent Emails
     * @return String - URL to redirect to the view (cartelApp.html)
     */
    @GetMapping("/mostSentEmails")
    public String getPersonWithMostSentEmails(Model model) {
        List <EmailDTO> result = emailService.getPersonWithMostSentEmails();
        model.addAttribute("mostSentEmails", result);
        model.addAttribute("person", new Person());
        return "cartelApp";
    }

    /**
     * Handle a GET request to get the List of Persons with most received Emails
     * @param model placeholder to populate the HTML template
     *              with the list of Persons with most received Emails
     * @return String - URL to redirect to the view (cartelApp.html)
     */
    @GetMapping("/mostReceivedEmails")
    public String getPersonWithMostReceivedEmails(Model model) {
        List <EmailDTO> result = emailService.getPersonWithMostReceivedEmails();
        model.addAttribute("mostReceivedEmails", result);
        model.addAttribute("person", new Person());
        return "cartelApp";
    }


    /**
     * Handle a GET request to get the List of  pairs of Persons with most sent/received Emails
     * @param model placeholder to populate the HTML template
     *              with the list of pairs of Persons with most Email interactions
     *              and the sum of its weights
     * @return String - URL to redirect to the view (cartelApp.html)
     */

    @GetMapping("/topEmailInteractions")
    public String getTopEmailInteractions(Model model) {
        List<InteractionsDTO> results = emailService.getTopEmailInteractions();
        model.addAttribute("topEmailInteractions", results);
        model.addAttribute("person", new Person());
        return "cartelApp";
    }

    /**
     * Handle a GET request to retrieve the top 5 persons based on the scores
     * resulting from the pageRank algorithm.
     * @param model placeholder to populate the HTML template
     *              with the list of pairs of Persons with most Email interactions
     *              and the sum of its weights
     * @return String - URL to redirect to the view (cartelApp.html)
     */

    @GetMapping("/top5PageRankedPersons")
    public String getTop5PageRankedPersons(Model model) {
        List<PageRankDTO> top5PageRankedPersons = emailService.getTop5PageRankedPersons();
        // Debugging line to print the list contents to the console
        System.out.println(top5PageRankedPersons);
        model.addAttribute("top5PageRankedPersons", top5PageRankedPersons);
        model.addAttribute("person", new Person());
        return "cartelApp";
    }

    /**
     * Handle a GET request to retrieve the top 5 persons based on the scores
     * resulting from the betweenness centrality algorithm.
     * @param model placeholder to populate the HTML template
     *              with the list of pairs of Persons with most Email interactions
     *              and the sum of its weights
     * @return String - URL to redirect to the view (cartelApp.html)
     */

    @GetMapping("/top5BetCenPersons")
    public String getTop5BetCenPersons(Model model) {
        List<BetCenDTO> top5BetCenPersons = emailService.getTop5BetCenPersons();
        // Debugging line to print the list contents to the console
        System.out.println(top5BetCenPersons);
        model.addAttribute("top5BetCenPersons", top5BetCenPersons);
        model.addAttribute("person", new Person());
        return "cartelApp";
    }

    /**
     * Handle a GET request to get the List of Persons with most sent Messages
     * @param model placeholder to populate the HTML template
     *              with the list of Persons with most sent Messages
     * @return String - URL to redirect to the view (cartelApp.html)
     */

    @GetMapping("/mostSentMessages")
    public String getPersonWithMostSentMessages(Model model) {
        List<MessageDTO> result = messageService.getPersonWithMostSentMessages();
        model.addAttribute("mostSentMessages", result);
        model.addAttribute("person", new Person());
        return "cartelApp";
    }


    /**
     * Handle a GET request to get the List of Persons with most received Messages
     * @param model placeholder to populate the HTML template
     *              with the list of Persons with most received Messages
     * @return String - URL to redirect to the view (cartelApp.html)
     */


    @GetMapping("/mostReceivedMessages")
    public String getPersonWithMostReceivedMessages(Model model) {
        List <MessageDTO> result = messageService.getPersonWithMostReceivedMessages();
        model.addAttribute("mostReceivedMessages", result);
        model.addAttribute("person", new Person());
        return "cartelApp";
    }

    /**
     * Handle a GET request to get the List of  pairs of Persons with most sent/received Messages
     * @param model placeholder to populate the HTML template
     *              with the list of pairs of Persons with most Message interactions
     *              and its added weights
     * @return String - URL to redirect to the view (cartelApp.html)
     */
    @GetMapping("/topMessageInteractions")
    public String getTopMessageInteractions(Model model) {
        List<InteractionsDTO> results = messageService.getTopMessageInteractions();
        model.addAttribute("topMessageInteractions", results);
        model.addAttribute("person", new Person());
        return "cartelApp";
    }

    /**
     * Handle a GET request to get the List of pairs of Persons with most sent/received
     * written communications (Messages & Emails combined).
     * @param model placeholder to populate the HTML template
     *              with the list of pairs of Persons with most combined interactions
     *              and its added weights (sum).
     * @return String - URL to redirect to the view (cartelApp.html).
     */
    @GetMapping("/topCombinedInteractions")
    public String getTopCombinedInteractions(Model model) {
        List<InteractionsDTO> results = emailService.getTopCombinedInteractions();
        model.addAttribute("topCombinedInteractions", results);
        model.addAttribute("person", new Person());
        return "cartelApp";
    }

}




