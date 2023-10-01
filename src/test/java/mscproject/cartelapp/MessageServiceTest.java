package mscproject.cartelapp;

import mscproject.cartelapp.DTO.MessageDTO;
import mscproject.cartelapp.repository.MessageRepository;
import mscproject.cartelapp.service.MessageService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

public class MessageServiceTest {

    @Mock
    private MessageRepository messageRepository;

    @InjectMocks
    private MessageService messageService;

    @BeforeEach
    public void setUp() {
            MockitoAnnotations.initMocks(this);
        }

        @Test
        public void getPersonWithMostSentMessagesTest () {
            List<MessageDTO> mockList = Arrays.asList(
                    new MessageDTO("Tito", 5L, 30, 33),
                    new MessageDTO("Jose", 4L, 22,34)
            );

            when(messageRepository.findTop10SentMessages()).thenReturn(mockList);

            List<MessageDTO> resultList = messageService.getPersonWithMostSentMessages();
            assertEquals(2, resultList.size());
            assertEquals("Tito", resultList.get(0).getName());
        }

        @Test
        public void getPersonWithMostReceivedMessagesTest () {
            List<MessageDTO> mockList = Arrays.asList(
                    new MessageDTO("Tito", 7L, 30, 33),
                    new MessageDTO("Jose", 6L, 23, 44)
            );

            when(messageRepository.findTop10ReceivedMessages()).thenReturn(mockList);

            List<MessageDTO> resultList = messageService.getPersonWithMostReceivedMessages();
            assertEquals(2, resultList.size());
            assertEquals("Tito", resultList.get(0).getName());
        }

    }