package mscproject.cartelapp.repository;

import mscproject.cartelapp.entity.Call;
import mscproject.cartelapp.entity.Firm;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CallRepository extends Neo4jRepository<Call, Long> {

}
