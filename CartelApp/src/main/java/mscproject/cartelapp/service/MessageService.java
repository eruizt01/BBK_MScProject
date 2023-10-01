package mscproject.cartelapp.service;

import mscproject.cartelapp.DTO.InteractionsDTO;
import mscproject.cartelapp.DTO.MessageDTO;
import mscproject.cartelapp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 *  Service class for the Message Repository.
 * @author eruizt01
 */

@Service
public class MessageService {
    private final MessageRepository messageRepository;

    /**
     * Constructor for MessageService
     * @param messageRepository
     */
    @Autowired
    public MessageService(MessageRepository messageRepository) {

        this.messageRepository = messageRepository;
    }

    /**
     * List of top 10 persons with most sent messages
     * @return List<MessageDTO> representing Person nodes with most sent messages.
     */

    public List<MessageDTO> getPersonWithMostSentMessages() {
        return messageRepository.findTop10SentMessages();
    }

    /**
     * List of top 10 persons with most received messages
     * @return List<MessageDTO> representing Person nodes with most received messages.
     */


    public List<MessageDTO> getPersonWithMostReceivedMessages() { return messageRepository.findTop10ReceivedMessages();
    }

    /**
     * List of top 10 persons with most combined sent & received messages
     * @return List<MessageDTO> representing Person nodes with most combined sent & received messages.
     */

    public List<InteractionsDTO> getTopMessageInteractions() {
        return messageRepository.findTopMessageInteractions();   }



}