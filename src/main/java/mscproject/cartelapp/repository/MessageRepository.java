package mscproject.cartelapp.repository;

import mscproject.cartelapp.DTO.EmailDTO;
import mscproject.cartelapp.DTO.InteractionsDTO;
import mscproject.cartelapp.DTO.MessageDTO;
import mscproject.cartelapp.entity.Firm;
import mscproject.cartelapp.entity.Message;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for the Message entity.
 * Extends the Neo4jRepository to deal with operations related to
 * Message entities.
 *
 * @author eruizt01
 */
@Repository
public interface MessageRepository extends Neo4jRepository<Message, Long>
{

    /**
     * Fetch the 10 Persons with the most sent messages.
     * @return a list of MessageDTOs with the 10 Persons with the most sent messages.
     */
    @Query("MATCH (p:Person)-[r:SENT]->(:Message) RETURN p.name as name, COUNT(r) AS numberOfMessagesSent, SUM(r.Weight) AS totalWeight ORDER BY numberOfMessagesSent DESC LIMIT 10")
    List<MessageDTO> findTop10SentMessages();

    /**
     * Fetch the 10 Persons with the most received messages.
     * @return a list of MessageDTOs with the 10 Persons with the most received messages.
     */

    @Query("MATCH (p:Person)-[r:RECEIVED]->(:Message) RETURN p.name as name, COUNT(r) AS numberOfMessagesReceived, SUM(r.Weight) AS totalWeight ORDER BY numberOfMessagesReceived DESC LIMIT 10")
    List<MessageDTO> findTop10ReceivedMessages();

    /**
     * Fetch the 10 pairs of Persons with the most sent and received message interactions.
     * @return a list of InteractionsDTOs with the 10 pairs of Persons with the most sent and received message interactions.
     */

    @Query("MATCH (p1:Person)-[s:SENT]->(m:Message)<-[r:RECEIVED]-(p2:Person) RETURN p1.name as person1, p2.name as person2, SUM(r.Weight) AS totalWeight ORDER BY totalWeight DESC LIMIT 10")
    List<InteractionsDTO> findTopMessageInteractions();



}
