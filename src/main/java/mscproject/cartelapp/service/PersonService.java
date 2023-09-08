package mscproject.cartelapp.service;

import mscproject.cartelapp.repository.PersonRepository;
import mscproject.cartelapp.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Scanner;

/**
 *
 */

@Service
public class PersonService {
    private final PersonRepository personRepository;

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * Creates a person
     */
    public void createPerson() {
        Person person = new Person("Sebastian", "Bach", 33,
                "employee", "xxx@gmail.com", "12345678");
        personRepository.save(person);
    }

    // Deletes a person
    public void deletePerson(Long id) {
        personRepository.deleteById(id);
    }



    /**
     * Print all persons sorted by name
     */

    public void printAllPersonsSortedByName() {
        // Define a sort order by name in ascending order
        Sort sort = Sort.by(Sort.Order.asc("name"));

        // Retrieve all persons from the repository and sort them
        Iterable<Person> sortedPersons = personRepository.findAll(sort);

        // Print the sorted persons
        for (Person person : sortedPersons) {
            System.out.println(person.getName());
        }
    }


}
