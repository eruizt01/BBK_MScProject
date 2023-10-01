package mscproject.cartelapp.entity;

import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.List;

/**
 * @Node annotation defines the class as a node ("Firm")
 * @author eruizt01
 */

    @Node
    public class Product {


    private String name;

    private String Category;

    private String SKU;

    @Id @GeneratedValue
    private Long id;

    @Relationship(type = "SELLS", direction = Relationship.Direction.INCOMING)
    private List<Firm> firms;


    //Getters and setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getCategory() {
        return Category;
    }

    public String getSKU() {
        return SKU;
    }

    public void setSKU(String SKU) {
        this.SKU = SKU;
    }

    public Long getId() {
        return id;
    }


    //Default constructor
    public Product() {
    }

    public Product(String name, String Category, String SKU) {
        this.name = name;
        this.Category = Category;
        this.SKU = SKU;
    }

    }


    /*@Relationship(type = "SOLD", direction = Relationship.Direction.INCOMING)
    private List<Products> products;*/
