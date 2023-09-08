package mscproject.cartelapp.service;

import mscproject.cartelapp.repository.EmailRepository;
import mscproject.cartelapp.repository.ProductRepository;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.neo4j.driver.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class EmailService {
    private final EmailRepository emailRepository;

    @Autowired
    public EmailService(EmailRepository emailRepository) {
        this.emailRepository = emailRepository;
    }



        public Map<String, Object> getPersonWithMostSentEmails() {
            return emailRepository.findPersonWithMostSentEmails();
        }

        public Map<String, Object> getPersonWithMostReceivedEmails() {
            return emailRepository.findPersonWithMostReceivedEmails();
        }

        public List<Map<String, Object>> getTopEmailInteractions() {
            return emailRepository.findTopEmailInteractions();
        }
    }

    