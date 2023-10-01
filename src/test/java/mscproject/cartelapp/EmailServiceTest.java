package mscproject.cartelapp;

import mscproject.cartelapp.DTO.BetCenDTO;
import mscproject.cartelapp.DTO.EmailDTO;
import mscproject.cartelapp.DTO.InteractionsDTO;
import mscproject.cartelapp.DTO.PageRankDTO;
import mscproject.cartelapp.repository.EmailRepository;
import mscproject.cartelapp.service.EmailService;
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
 * Test class for the EmailService class.
 * @author eruizt01
 */

class EmailServiceTest {

    @Mock
    private EmailRepository emailRepository;

    @InjectMocks
    private EmailService emailService;

    //  Set up the test environment

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    //  Test the service methods
    @Test
    void testGetPersonWithMostSentEmails() {
        // Mock the repository call
        when(emailRepository.findTop10SentEmails()).thenReturn(new ArrayList<>());

        List<EmailDTO> result = emailService.getPersonWithMostSentEmails();

        // Assert and verify
        assertNotNull(result);
        verify(emailRepository, times(1)).findTop10SentEmails();
    }



    @Test
    void testGetPersonWithMostReceivedEmails() {
        when(emailRepository.findTop10ReceivedEmails()).thenReturn(new ArrayList<>());

        List<EmailDTO> result = emailService.getPersonWithMostReceivedEmails();

        assertNotNull(result);
        verify(emailRepository, times(1)).findTop10ReceivedEmails();
    }


    @Test
    void testGetTopEmailInteractions() {
        when(emailRepository.findTopEmailInteractions()).thenReturn(new ArrayList<>());

        List<InteractionsDTO> result = emailService.getTopEmailInteractions();

        assertNotNull(result);
        verify(emailRepository, times(1)).findTopEmailInteractions();
    }

    @Test
    void testGetTopCombinedInteractions() {
        when(emailRepository.findTopCombinedInteractions()).thenReturn(new ArrayList<>());

        List<InteractionsDTO> result = emailService.getTopCombinedInteractions();

        assertNotNull(result);
        verify(emailRepository, times(1)).findTopCombinedInteractions();
    }

    @Test
    void testGetTop5PageRankedPersons() {
        when(emailRepository.findTop5PageRankedPersons()).thenReturn(new ArrayList<>());

        List<PageRankDTO> result = emailService.getTop5PageRankedPersons();

        assertNotNull(result);
        verify(emailRepository, times(1)).findTop5PageRankedPersons();
    }

    @Test
    void testGetTop5BetCenPersons() {
        when(emailRepository.findTop5BetCenPersons()).thenReturn(new ArrayList<>());

        List<BetCenDTO> result = emailService.getTop5BetCenPersons();

        assertNotNull(result);
        verify(emailRepository, times(1)).findTop5BetCenPersons();
    }
}
