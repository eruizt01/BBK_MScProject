package mscproject.cartelapp.service;

import mscproject.cartelapp.DTO.InteractionsDTO;
import mscproject.cartelapp.DTO.MessageDTO;
import mscproject.cartelapp.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageService {
    private final MessageRepository messageRepository;

    @Autowired
    public MessageService(MessageRepository messageRepository) {

        this.messageRepository = messageRepository;
    }


    public List<MessageDTO> getPersonWithMostSentMessages() {
        return messageRepository.findTop10SentMessages();
    }

    public List<MessageDTO> getPersonWithMostReceivedMessages() { return messageRepository.findTop10ReceivedMessages();
    }



}