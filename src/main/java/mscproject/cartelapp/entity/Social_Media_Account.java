package mscproject.cartelapp.entity;

import org.springframework.data.neo4j.core.schema.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @Node annotation defines the class as a node ("Social_Media_Account")
 *
 *
 * @author eruizt01
 */

    @Node (labels = {"Social_Media_Account"})
    public class Social_Media_Account {

    //Properties

    @Property ("date_created")
    private LocalDate date_created;

    @Property ("last_activity")
    private LocalDate last_activity;

    @Property ("platform")
    private String platform;

    @Property ("username")
    private String userName;

    @Id @GeneratedValue
    private Long id;

    //Relationship between Person and a Social Media Account
    @Relationship(type = "HAS_ACCOUNT", direction = Relationship.Direction.INCOMING)
    private List<Person> accountOwners;


    //Getters & setters

    public LocalDate getDate_created() {
        return date_created;
    }

    public void setDate_created(LocalDate date_created) {
        this.date_created = date_created;
    }

    public LocalDate getLast_activity() {
        return last_activity;
    }

    public void setLast_activity(LocalDate last_activity) {
        this.last_activity = last_activity;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public long getId() {
        return id;
    }


    //Default constructor
    public Social_Media_Account() {
    }

    /**
     * Constructor for Social_Media_Accoiunt
     * @ param date_created
     * @param last_activity
     * @param platform
     * @param userName

     */


    public Social_Media_Account( LocalDate date_created, LocalDate last_activity, String platform, String userName) {
        this.date_created = date_created;
        this.last_activity = last_activity;
        this.platform = platform;
        this.userName = userName;
    }

}
