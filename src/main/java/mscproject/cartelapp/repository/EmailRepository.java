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

@Repository
public interface EmailRepository extends Neo4jRepository<Email, Long> {

    @Query("MATCH (p:Person)-[r:SENT]->(:Email) RETURN p.name as name, COUNT(r) AS numberOfEmailsSent, SUM(r.Weight) AS totalWeight ORDER BY numberOfEmailsSent DESC LIMIT 10")
    List<EmailDTO> findTop10SentEmails();

    @Query("MATCH (p:Person)-[r:RECEIVED]->(:Email) RETURN p.name as name, COUNT(r) AS numberOfEmailsReceived, SUM(r.Weight) AS totalWeight ORDER BY numberOfEmailsReceived DESC LIMIT 10")
    List<EmailDTO> findTop10ReceivedEmails();

    @Query("MATCH (p1:Person)-[s:SENT]->(e:Email)<-[r:RECEIVED]-(p2:Person) WHERE id(p1) < id(p2)  RETURN p1.name as person1, p2.name as person2, SUM(r.Weight) AS totalWeight ORDER BY totalWeight DESC LIMIT 10")
    List<InteractionsDTO> findTopEmailInteractions();

    //Page Rank
    @Query("MATCH (p:Person) RETURN p.name AS name, p.pageRank AS pageRank ORDER BY p.pageRank DESC LIMIT 5")
    List<PageRankDTO> findTop5PageRankedPersons();

    @Query("MATCH (p:Person) RETURN p.name AS name, p.betweennessCentrality AS betweennessCentrality ORDER BY p.betweennessCentrality DESC LIMIT 5")
    List<BetCenDTO> findTop5BetCenPersons();
}

