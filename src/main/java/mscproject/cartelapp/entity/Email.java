package mscproject.cartelapp.entity;

import org.springframework.data.neo4j.core.schema.*;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * @Node annotation defines the class as a node ("Email")
 *
 *
 * @author eruizt01
 */

    @Node (labels = {"Email"})
    public class Email {

    //Properties

    @Property ("date")
    private LocalDate date;
    @Property ("Weight")
    private Integer weight;

    @Property ("Flag")
    private String flag;

    @Property ("receiver_address")
    private String receiver_address;

    @Property ("sender_address")
    private String sender_address;

    @Property ("time")
    private LocalTime time;

    @Id @GeneratedValue
    private Long id;

    //Relationship between Person and Call
    @Relationship(type = "SENT", direction = Relationship.Direction.INCOMING)
    private List<Person> emailSenders;
    //Relationship between Person and Person
    @Relationship(type = "RECEIVED", direction = Relationship.Direction.OUTGOING)
    private List<Person> emailReceivers;


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


    public String getReceiver_address() {
        return receiver_address;
    }

    public void setReceiver_address(String receiver_address) {
        this.receiver_address = receiver_address;
    }

    public String getSender_address() {
        return sender_address;
    }

    public void setSender_address(String sender_address) {
        this.sender_address = sender_address;
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
    public Email() {
    }

    /**
     * Constructor for Email
     *
     * @param date
     * @param weight
     * @param flag
     * @param receiver_address
     * @param sender_address
     * @param time
     *
     */

    public Email( LocalDate date, Integer weight, String flag, String receiver_address,
                  String sender_address, LocalTime time) {
        this.date = date;
        this.weight = weight;
        this.flag = flag;
        this.receiver_address = receiver_address;
        this.sender_address = sender_address;
        this.time = time;
    }

}
