package mscproject.cartelapp.repository;

import mscproject.cartelapp.entity.Firm;
import mscproject.cartelapp.entity.Message;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MessageRepository extends Neo4jRepository<Message, Long>
{

}
