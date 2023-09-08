package mscproject.cartelapp.repository;

import mscproject.cartelapp.entity.Email;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public interface EmailRepository extends Neo4jRepository<Email, Long> {

    @Query("MATCH (p:Person)-[r:SENT]->(:Email) RETURN p.name as name, SUM(r.Weight) AS totalWeight ORDER BY totalWeight DESC LIMIT 1")
    Map<String, Object> findPersonWithMostSentEmails();

    @Query("MATCH (p:Person)<-[r:RECEIVED]-(:Email) RETURN p.name as name, SUM(r.Weight) AS totalWeight ORDER BY totalWeight DESC LIMIT 1")
    Map<String, Object> findPersonWithMostReceivedEmails();

    @Query("MATCH (p1:Person)-[r:SENT|RECEIVED]-(p2:Person) WHERE id(p1) < id(p2)  RETURN p1.name as person1, p2.name as person2, SUM(r.Weight) AS totalWeight ORDER BY totalWeight DESC LIMIT 10")
    List<Map<String, Object>> findTopEmailInteractions();
}
