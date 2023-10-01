package mscproject.cartelapp.entity;

import org.springframework.data.neo4j.core.schema.*;

import java.time.LocalDate;
import java.util.List;

/**
 * @Node annotation defines the class as a node ("Group Chat")
 *
 *
 * @author eruizt01
 */

    @Node (labels = {"Group_Chat"})
    public class Group_Chat {

    //Properties

    @Property ("date_created")
    private LocalDate date_created;

    @Property ("flag")
    private String flag;

    @Property ("platform")
    private String platform;

    @Property ("name")
    private String name;

    @Id @GeneratedValue
    private Long id;

    //Relationship between Person and a Social Media Account
    @Relationship(type = "MEMBER_OF", direction = Relationship.Direction.INCOMING)
    private List<Person> groupChatMembers;


    //Getters & setters

    public LocalDate getDate_created() {
        return date_created;
    }

    public void setDate_created(LocalDate date_created) {
        this.date_created = date_created;
    }

    public String getName() {
        return name;
    }

    public void setUserName(String name) {
        this.name = name;
    }

    public String getFlag() { return flag; }

    public void setFlag(String flag) { this.flag = flag; }

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
    public Group_Chat() {
    }

    /**
     * Constructor for Group_Chat
     * @param date_created
     * @param flag
     * @param platform
     * @param name
     */

    public Group_Chat( LocalDate date_created, String flag, String platform, String name) {
        this.date_created = date_created;
        this.flag = flag;
        this.platform = platform;
        this.name = name;
    }

}
