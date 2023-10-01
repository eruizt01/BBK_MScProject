package mscproject.cartelapp.repository;

import mscproject.cartelapp.DTO.BetCenDTO;
import mscproject.cartelapp.DTO.EmailDTO;
import mscproject.cartelapp.DTO.InteractionsDTO;
import mscproject.cartelapp.DTO.PageRankDTO;
import mscproject.cartelapp.entity.Email;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Repository interface for the Email entity.
 * Extends the Neo4jRepository to deal with operations related to
 * Email entities.
 *
 * @author eruizt01
 */
@Repository
public interface EmailRepository extends Neo4jRepository<Email, Long> {

    /**
     * Fetch the 10 Persons with the most sent emails.
     * @return a list of EmailDTOs with the 10 Persons with the most sent emails.
     */
    @Query("MATCH (p:Person)-[r:SENT]->(:Email) RETURN p.name as name, COUNT(r) AS numberOfEmailsSent, SUM(r.Weight) AS totalWeight ORDER BY numberOfEmailsSent DESC LIMIT 10")
    List<EmailDTO> findTop10SentEmails();

    /**
     * Fetch the 10 Persons with the most received emails.
     * @return a list of EmailDTOs with the 10 Persons with the most received emails.
     */
    @Query("MATCH (p:Person)-[r:RECEIVED]->(:Email) RETURN p.name as name, COUNT(r) AS numberOfEmailsReceived, SUM(r.Weight) AS totalWeight ORDER BY numberOfEmailsReceived DESC LIMIT 10")
    List<EmailDTO> findTop10ReceivedEmails();

    /**
     * Fetch the 10 pairs of Persons with the most sent and received emails.
     * @return a list of EmailDTOs with the 10 pairs of Persons with the most sent and received emails.
     */
    @Query("MATCH (p1:Person)-[s:SENT]->(e:Email)<-[r:RECEIVED]-(p2:Person) RETURN p1.name as person1, p2.name as person2, SUM(r.Weight) AS totalWeight ORDER BY totalWeight DESC LIMIT 10")
    List<InteractionsDTO> findTopEmailInteractions();

    /**
     * Fetch the top 5 Persons with the highest Page Rank.
     * @return a list of PageRankDTOs with the top 5 Persons with the highest Page Rank.
     */
    //Page Rank
    @Query("MATCH (p:Person) RETURN p.name AS name, p.pageRank AS pageRank ORDER BY p.pageRank DESC LIMIT 5")
    List<PageRankDTO> findTop5PageRankedPersons();

    /**
     * Fetch the top 5 Persons with the highest Betweenness Centrality.
     * @return a list of BetCenDTOs with the top 5 Persons with the highest Betweenness Centrality.
     */

    @Query("MATCH (p:Person) RETURN p.name AS name, p.betweennessCentrality AS betweennessCentrality ORDER BY p.betweennessCentrality DESC LIMIT 5")
    List<BetCenDTO> findTop5BetCenPersons();

    /**
     * Fetch the top 10 Persons with the highest combined weight of sent and received
     * emails and Messages.
     * @return a list of InteractionsDTOs with the top 10 Persons
     * with the highest combined weight of sent and received emails and Messages.
     */
    @Query("MATCH (p1:Person)-[:SENT]->(c)<-[:RECEIVED]-(p2:Person) WHERE (c:Message OR c:Email) RETURN p1.name as person1, p2.name as person2, SUM(c.Weight) AS totalWeight ORDER BY totalWeight DESC LIMIT 10")
    List<InteractionsDTO> findTopCombinedInteractions();
}

