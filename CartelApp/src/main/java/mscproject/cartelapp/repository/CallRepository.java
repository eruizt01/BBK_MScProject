package mscproject.cartelapp.repository;

import mscproject.cartelapp.entity.Call;
import mscproject.cartelapp.entity.Firm;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for the Call entity.
 * Extends the Neo4jRepository to deal with operations related to
 * Call entities.
 *
 * @author eruizt01
 */
@Repository
public interface CallRepository extends Neo4jRepository<Call, Long> {

}
