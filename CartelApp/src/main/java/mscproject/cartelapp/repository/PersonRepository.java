package mscproject.cartelapp.repository;

import mscproject.cartelapp.entity.Person;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for the Person entity.
 * Extends the Neo4jRepository to deal with operations related to
 * Person entities.
 *
 * @author eruizt01
 */
@Repository
public interface PersonRepository extends Neo4jRepository<Person, Long>
{
    Person findByName(String name);

}
