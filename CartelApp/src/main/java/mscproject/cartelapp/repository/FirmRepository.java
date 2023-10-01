package mscproject.cartelapp.repository;

import mscproject.cartelapp.entity.Firm;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for the Firm entity.
 * Extends the Neo4jRepository to deal with operations related to
 * Firm entities.
 *
 * @author eruizt01
 */
@Repository
public interface FirmRepository extends Neo4jRepository<Firm, Long>
{

}
