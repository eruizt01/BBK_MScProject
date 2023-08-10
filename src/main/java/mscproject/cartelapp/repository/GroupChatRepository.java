package mscproject.cartelapp.repository;

import mscproject.cartelapp.entity.Firm;
import mscproject.cartelapp.entity.Group_Chat;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GroupChatRepository extends Neo4jRepository<Group_Chat, Long>
{

}
