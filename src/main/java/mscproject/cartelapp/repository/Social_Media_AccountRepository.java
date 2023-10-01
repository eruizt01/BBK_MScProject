package mscproject.cartelapp.repository;

import mscproject.cartelapp.entity.Firm;
import mscproject.cartelapp.entity.Social_Media_Account;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for the Social_Media_Account entity.
 * Extends the Neo4jRepository to deal with operations related to
 * SMA entities.
 *
 * @author eruizt01
 */

@Repository
public interface Social_Media_AccountRepository extends Neo4jRepository<Social_Media_Account, Long>
{

}
