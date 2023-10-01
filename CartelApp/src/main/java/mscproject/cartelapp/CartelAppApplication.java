package mscproject.cartelapp;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

import mscproject.cartelapp.repository.ProductRepository;
import mscproject.cartelapp.service.EmailService;
import mscproject.cartelapp.service.FirmService;
import mscproject.cartelapp.service.PersonService;
import mscproject.cartelapp.service.ProductService;
import org.neo4j.driver.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import mscproject.cartelapp.repository.FirmRepository;
import mscproject.cartelapp.repository.PersonRepository;


/**
 * This class is the main entry point to the CartelApp
 *
 *  A Spring Boot application that is configured to integrate with a Neo4j
 *  for data storage and retrieval related to a cartel investigation.
 *  The application offers services related to CRUD operation relating to several entities..
 *  Once it is run, the application provides guidance to access it via a web browser.
 *
 * @autor eruizt01
 */


@SpringBootApplication
@EnableNeo4jRepositories("mscproject.cartelapp.repository")
@ComponentScan({"mscproject.cartelapp", "mscproject.cartelapp.controller"})
@EntityScan("mscproject.cartelapp.entity")
public class CartelAppApplication implements CommandLineRunner {

    @Autowired
    private final Driver driver;

    private final ConfigurableApplicationContext applicationContext;



    @Autowired
    private EmailService emailService;


    @Autowired
    private FirmService firmService;

    @Autowired
    private PersonService personService;

    /**
     * Constructor of the class CartelAppApplication
     * @param driver
     * @param applicationContext
     * @param productService
     * @param firmRepository
     * @param personRepository
     * @param productRepository
     * @param emailService
     * @param personService
     * @param firmService
     */

    public CartelAppApplication(Driver driver, ConfigurableApplicationContext applicationContext,
                                ProductService productService, FirmRepository firmRepository,
                                PersonRepository personRepository, ProductRepository productRepository, EmailService emailService, PersonService personService,
                                FirmService firmService) {
        this.driver = driver;
        this.applicationContext = applicationContext;
        this.emailService = emailService;
        this.personService = personService;
        this.firmService = firmService;
    }


    public static void main(String[] args) {
        SpringApplication.run(CartelAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Navigate to http://localhost:8080 to access the application.");

        // Open the default web browser to go to the application
        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            try {
                Desktop.getDesktop().browse(new URI("http://localhost:8080"));
            } catch (IOException | URISyntaxException e) {
                e.printStackTrace();
            }
        }
        System.out.println(); // Or log this information
        // Keep the application running until user input
        System.out.println("Press Enter to exit...");
        System.in.read(); // Wait for user input (Enter key)
    }
}
