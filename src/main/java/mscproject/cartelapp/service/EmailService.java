package mscproject.cartelapp.service;

import mscproject.cartelapp.DTO.BetCenDTO;
import mscproject.cartelapp.DTO.EmailDTO;
import mscproject.cartelapp.DTO.InteractionsDTO;
import mscproject.cartelapp.DTO.PageRankDTO;
import mscproject.cartelapp.repository.EmailRepository;
import mscproject.cartelapp.repository.ProductRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Map;


@Service
public class EmailService {
    private final EmailRepository emailRepository;

    @Autowired
    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }


    public List<EmailDTO> getPersonWithMostSentEmails() {

        return emailRepository.findTop10SentEmails();
    }

    public List<EmailDTO> getPersonWithMostReceivedEmails() {
        return emailRepository.findTop10ReceivedEmails();
    }

    public List<InteractionsDTO> getTopEmailInteractions() {
        return emailRepository.findTopEmailInteractions();
    }

    public List<PageRankDTO> getTop5PageRankedPersons() {
        return emailRepository.findTop5PageRankedPersons();
    }

    public List<BetCenDTO> getTop5BetCenPersons() {
        return emailRepository.findTop5BetCenPersons();
    }

}