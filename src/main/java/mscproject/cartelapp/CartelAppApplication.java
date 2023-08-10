package mscproject.cartelapp;

import mscproject.cartelapp.entity.Call;
import mscproject.cartelapp.entity.Person;
import mscproject.cartelapp.entity.Product;
import mscproject.cartelapp.repository.CallRepository;
import mscproject.cartelapp.repository.ProductRepository;
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


@SpringBootApplication
@EnableNeo4jRepositories("mscproject.cartelapp.repository")
@ComponentScan("mscproject.cartelapp")
@EntityScan ("mscproject.cartelapp.entity")
public class CartelAppApplication implements CommandLineRunner {

    @Autowired
    private final Driver driver;

    private final ConfigurableApplicationContext applicationContext;

    private ProductService productService;
    @Autowired
    private FirmRepository firmRepository;
    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private CallRepository callRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private FirmService firmService;

    @Autowired
    private PersonService personService;


    public CartelAppApplication(Driver driver, ConfigurableApplicationContext applicationContext,
                                ProductService productService, FirmRepository firmRepository,
                                PersonRepository personRepository, ProductRepository productRepository, PersonService personService,
                                FirmService firmService) {
        this.driver = driver;
        this.applicationContext = applicationContext;
        this.productService = productService;
        this.firmRepository = firmRepository;
        this.personRepository = personRepository;
        this.productRepository = productRepository;
        this.personService = personService;
        this.firmService = firmService;
    }


    public static void main(String[] args) {
        SpringApplication.run(CartelAppApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        //Print all Firms
        //firmService.printFirms();

        //Print all persons Sorted by name
        //personService.printAllPersonsSortedByName();

        //Create a person
        //personService.createPerson();

        //Create Products from an Excel file
        //productService.createProduct();

        //Delete a person
        //personService.deletePerson();


    }
}