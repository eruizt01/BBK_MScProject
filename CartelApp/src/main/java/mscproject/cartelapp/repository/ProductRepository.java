package mscproject.cartelapp.repository;

import mscproject.cartelapp.entity.Product;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository interface for the Product entity.
 * Extends the Neo4jRepository to deal with operations related to
 * Product entities.
 *
 * @author eruizt01
 */
@Repository
public interface ProductRepository extends Neo4jRepository<Product, Long>
{

}
