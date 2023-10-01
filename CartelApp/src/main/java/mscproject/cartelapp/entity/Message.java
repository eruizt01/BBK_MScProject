package mscproject.cartelapp.entity;

import org.springframework.data.neo4j.core.schema.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * @Node annotation defines the class as a node ("Message")
 *
 *
 * @author eruizt01
 */

    @Node (labels = {"Message"})
    public class Message {

    //Properties

    @Property ("date")
    private LocalDate date;
    @Property ("Weight")
    private Integer weight;

    @Property ("Flag")
    private String flag;

    @Property ("link_to_content")
    private String link_to_content;

    @Property ("platform")
    private String platform;

    @Property ("time")
    private LocalTime time;

    @Id @GeneratedValue
    private Long id;

    //Relationship between Person and Call
    @Relationship(type = "SENT", direction = Relationship.Direction.INCOMING)
    private List<Person> messageSenders;
    //Relationship between Person and Call
    @Relationship(type = "RECEIVED", direction = Relationship.Direction.OUTGOING)
    private List<Person> messageReceivers;


    //Getters & setters

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getLink_to_content() {
        return link_to_content;
    }

    public void setLink_to_content(String link_to_content) {
        this.link_to_content = link_to_content;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }
    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public long getId() {
        return id;
    }


    //Default constructor
    public Message() {
    }

    /**
     * Constructor for Email
     *
     * @param date
     * @param weight
     * @param flag
     * @param platform
     * @param link_to_content
     * @param time
     */

    public Message(LocalDate date, Integer weight, String flag, String platform,
                   String sender_address, String link_to_content, LocalTime time) {
        this.date = date;
        this.weight = weight;
        this.flag = flag;
        this.link_to_content = link_to_content;
        this.platform = platform;
        this.time = time;
    }

}
