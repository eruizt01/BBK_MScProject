package mscproject.cartelapp.entity;

import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

/**
 * @Node annotation defines the class as a node ("Firm")
 *
 * @author eruizt01
 */

    @Node (labels = {"Firm"})
    public class Firm {

    @Property ("name")
    private String firmName;


    @Id @GeneratedValue
    private Long id;


    //Default constructor
    public Firm() {
    }

    // Constructor
    public Firm(String firmName){
        this.firmName = firmName;
    }

    //Getter & setter
    public String getFirmName() {
        return firmName;
    }


    public void setFirmName(String firmName) {
        this.firmName = firmName;
    }


    public long getId() {
        return id;
    }

}
