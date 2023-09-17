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

@Repository
public interface MessageRepository extends Neo4jRepository<Message, Long>
{

    @Query("MATCH (p:Person)-[r:SENT]->(:Message) RETURN p.name as name, COUNT(r) AS numberOfMessagesSent, SUM(r.Weight) AS totalWeight ORDER BY numberOfMessagesSent DESC LIMIT 10")
    List<MessageDTO> findTop10SentMessages();

    @Query("MATCH (p:Person)-[r:RECEIVED]->(:Message) RETURN p.name as name, COUNT(r) AS numberOfMessagesReceived, SUM(r.Weight) AS totalWeight ORDER BY numberOfMessagesReceived DESC LIMIT 10")
    List<MessageDTO> findTop10ReceivedMessages();




}
