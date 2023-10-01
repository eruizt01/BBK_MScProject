package mscproject.cartelapp;

import mscproject.cartelapp.entity.Person;
import mscproject.cartelapp.repository.PersonRepository;
import mscproject.cartelapp.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Test class for the PersonService class.
 * @author eruizt01
 */
class PersonServiceTest {

    @Mock
    private PersonRepository personRepository;

    @InjectMocks
    private PersonService personService;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testFindAll() {
        when(personRepository.findAll()).thenReturn(new ArrayList<>());

        List<Person> result = personService.findAll();

        assertNotNull(result);
        verify(personRepository, times(1)).findAll();
    }

    @Test
    void testSavePerson() {
        Person mockPerson = new Person("Sebastian", "Bach", 33,
                "employee", "xxx@gmail.com", "12345678");

        personService.save(mockPerson);

        verify(personRepository, times(1)).save(mockPerson);
    }

    @Test
    void testDeleteById() {
        Long mockId = 1L;

        personService.deleteById(mockId);

        verify(personRepository, times(1)).deleteById(mockId);
    }
}
