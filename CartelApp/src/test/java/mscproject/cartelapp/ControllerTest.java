package mscproject.cartelapp;

import mscproject.cartelapp.DTO.BetCenDTO;
import mscproject.cartelapp.DTO.PageRankDTO;
import org.springframework.ui.Model;
import mscproject.cartelapp.DTO.EmailDTO;
import mscproject.cartelapp.DTO.PersonDTO;
import mscproject.cartelapp.controller.Controller;
import mscproject.cartelapp.entity.Person;
import mscproject.cartelapp.service.EmailService;
import mscproject.cartelapp.service.PersonService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

/**
 * Unit test for the controller class
 * @author eruizt01
 */

public class ControllerTest {

    @InjectMocks
    private Controller controller; //

    @Mock
    private EmailService emailService;
    @Mock
    private PersonService personService;

    // Mock the Model
    private Model model = mock(Model.class);

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testCreatePerson() {
        // Prepare data using a "mock" Person Data transfer Object
        PersonDTO mockDto = new PersonDTO();
        mockDto.setName("Tito");
        mockDto.setSurname("Tapia");
        mockDto.setAge(27);
        mockDto.setRole("Boxer");
        mockDto.setEmail_account("t.tapia@mejora.cl");
        mockDto.setPhone_number("07620418975");

        //Invoke the controller's createPerson method with the mock DTO
        String result = controller.createPerson(mockDto);

        // The "save method" should be called only once
        verify(personService, times(1)).save(any(Person.class));

        // Verify that the controller's response is the expected redirection URL
        assertEquals("redirect:/", result);
    }

    @Test
    void testDeletePerson() {
        // Given: Sample Long (ID) to be deleted
        Long mockId = 123L;

        //The deletePerson method is called with the mock ID
        String result = controller.deletePerson(mockId);

        // Verify that the deleteById method on personService was called with the mock ID
        verify(personService, times(1)).deleteById(mockId);

        // Controller's response should be the expected redirection URL
        assertEquals("redirect:/", result);
    }

    @Test
    void testGetPersonWithMostSentEmails() {
        // Given: A mock list of EmailDTO returned by the service
        List<EmailDTO> mockList = new ArrayList<>();
        EmailDTO mockEmailDTO = new EmailDTO("Tito", 200L, 33, 44);
        // Populate mockEmailDTO if necessary...
        mockList.add(mockEmailDTO);
        when(emailService.getPersonWithMostSentEmails()).thenReturn(mockList);

        // The getPersonWithMostSentEmails method is called
        String viewName = controller.getPersonWithMostSentEmails(model);

        // Verify that attributes were added to the model
        verify(model, times(1)).addAttribute(eq("mostSentEmails"), eq(mockList));
        verify(model, times(1)).addAttribute(eq("person"), any(Person.class)); // Here we're just checking that any Person object was added to the model

        // Test that the controller's response is the expected view name
        assertEquals("cartelApp", viewName);
    }

    @Test
    void testGetTop5PageRankedPersons() {
        // Given: A mock list of PageRankDTO returned by the service
        List<PageRankDTO> mockList = new ArrayList<>();
        PageRankDTO mockPageRankDTO = new PageRankDTO("Tito", 1.0); // Assuming PageRankDTO has such a constructor
        mockList.add(mockPageRankDTO);
        when(emailService.getTop5PageRankedPersons()).thenReturn(mockList);

        // The getTop5PageRankedPersons method is called
        String viewName = controller.getTop5PageRankedPersons(model);

        // Verify that attributes were added to the model
        verify(model, times(1)).addAttribute(eq("top5PageRankedPersons"), eq(mockList));
        verify(model, times(1)).addAttribute(eq("person"), any(Person.class)); // Here we're just checking that any Person object was added to the model

        // Test that the controller's response is the expected view name
        assertEquals("cartelApp", viewName);
    }
    @Test
    void testGetTop5BetCenPersons() {
        // Given: A mock list of BetCenDTO returned by the service
        List<BetCenDTO> mockList = new ArrayList<>();
        BetCenDTO mockBetCenDTO = new BetCenDTO("Tito", 2.0);
        when(emailService.getTop5BetCenPersons()).thenReturn(mockList);

        // call getTop5BetCenPersons
        String viewName = controller.getTop5BetCenPersons(model);

        // Use "verify" from Mockito testing to check that attributes were added to the model
        verify(model, times(1)).addAttribute(eq("top5BetCenPersons"), eq(mockList));
        verify(model, times(1)).addAttribute(eq("person"), any(Person.class)); // Here we're just checking that any Person object was added to the model

        // Test that the controller's response is the expected view name
        assertEquals("cartelApp", viewName);
    }

}

