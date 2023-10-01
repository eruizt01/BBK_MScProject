package mscproject.cartelapp.service;

import mscproject.cartelapp.repository.PersonRepository;
import mscproject.cartelapp.entity.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Scanner;

/**
 *  Service class for the Person Repository.
 * @author eruizt01
 */

@Service
public class PersonService {
    private final PersonRepository personRepository;

    /**
     * Constructor for PersonService
     * @param personRepository
     */

    @Autowired
    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    /**
     * Creates a person with predefined values
     * @return Person
     * (this method is not implemented in the view)
     */
    public void createPerson() {
        Person person = new Person("Sebastian", "Bach", 33,
                "employee", "xxx@gmail.com", "12345678");
        personRepository.save(person);
    }



    /**
     * find all Person nodes in the database
     * @return a List of Person nodes
     */

    public List<Person> findAll() {
        return personRepository.findAll();
    }

    /**
     * Save a person in the database
     * @param person to be saved
     */

    public void save(Person person) {
        personRepository.save(person);
    }
    /**
     * delete a person by id
     * @param id of the person to delete
     */

    public void deleteById(Long id) {
        personRepository.deleteById(id);
    }



}
