package mscproject.cartelapp.UI;
import mscproject.cartelapp.service.FirmService;
import mscproject.cartelapp.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class CommandLineInterface implements CommandLineRunner {

    @Autowired
    private PersonService personService;

    @Autowired
    private FirmService firmService;

    public CommandLineInterface(PersonService personService, FirmService firmService) {
        this.personService = personService;
        this.firmService = firmService;
    }

    // Inject other services here...

    @Override
    public void run(String... args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Choose an option:");
            System.out.println("1: Create a Person");
            System.out.println("2: Create a Firm");
            System.out.println("3: Run Algorithm X");
            System.out.println("4: Exit");

            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    personService.createPerson();
                    break;

                case "2":
                   // firmService.createFirm();
                    break;

                case "3":
                    // Call some other service to execute algorithm X
                    break;

                case "4":
                    System.out.println("Exiting...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
