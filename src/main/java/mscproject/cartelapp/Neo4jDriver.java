package mscproject.cartelapp;


import org.neo4j.driver.*;
import org.neo4j.driver.types.Node;

    /*public class Neo4jDriver {

        public static void main(String[] args) {
            // Create a driver instance
            Driver driver = GraphDatabase.driver("bolt://localhost:7687", AuthTokens.basic("neo4j",
                    "bbk12345"));

            try (Session session = driver.session()) {
                // Run the Cypher query
                Result result = session.run("MATCH (f:Firm) RETURN f");

                // Iterate over the result stream
                while (result.hasNext()) {
                    org.neo4j.driver.Record record = result.next(); // Fully qualify the Record class
                    // Handle each record as needed
                    Node firmNode = record.get("f").asNode();
                    System.out.println(firmNode.asMap());
                }


                // Close the driver when you're done
                driver.close();
            }
        }
    }*/


