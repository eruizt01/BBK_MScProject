package mscproject.cartelapp.repository;

import mscproject.cartelapp.entity.Email;
import mscproject.cartelapp.entity.Firm;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmailRepository extends Neo4jRepository<Email, Long>
{

}
