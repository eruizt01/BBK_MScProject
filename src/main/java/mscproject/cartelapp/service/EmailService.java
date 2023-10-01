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


/**
 * Service class for the Email Repository.
 * Bridge between the Controller and the EmailRepository layer.
 * @author eruizt01
 */

@Service
public class EmailService {
    private final EmailRepository emailRepository;

    /**
     * Constructor for EmailService
     * @param emailRepository
     */
    @Autowired
    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }


    /**
     * Method to get the top 10 persons with most sent emails
     * @return List<EmailDTO> representing Person nodes with most sent emails
     */
    public List<EmailDTO> getPersonWithMostSentEmails() {

        return emailRepository.findTop10SentEmails();
    }


    /**
     * Method to get the top 10 persons with most received emails
     * @return List<EmailDTO> representing Person nodes with most received emails
     */
    public List<EmailDTO> getPersonWithMostReceivedEmails() {
        return emailRepository.findTop10ReceivedEmails();
    }

    /**
     * Method to get the top 10 persons with top Email interactions
     * @return List<EmailDTO> representing Person most Email interactions
     */
    public List<InteractionsDTO> getTopEmailInteractions() {
        return emailRepository.findTopEmailInteractions();
    }

    /**
     * Method to get the top 10 persons with top combined Email & Message interactions
     * @return List<EmailDTO> representing Person mbined Email & Message interactions
     */
    public List<InteractionsDTO> getTopCombinedInteractions() {
        return emailRepository.findTopCombinedInteractions();
    }


    /**
     * List of top 5 PageRanked Persons
     * @return List<PageRankDTO> representing Person nodes with top PageRank scores
     */
    public List<PageRankDTO> getTop5PageRankedPersons() {
        return emailRepository.findTop5PageRankedPersons();
    }

    /**
     * List of top 5 BetCen Persons
     * @return List<BetCenDTO> representing Person nodes with top Betweenness Centrality scores
     */
    public List<BetCenDTO> getTop5BetCenPersons() {
        return emailRepository.findTop5BetCenPersons();
    }

}