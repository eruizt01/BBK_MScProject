package mscproject.cartelapp.entity;

import org.springframework.data.neo4j.core.schema.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * @Node annotation defines the class as a node ("Call")
 *
 *
 * @author eruizt01
 */

    @Node (labels = {"Call"})
    public class Call {

    //Properties

    @Property ("date")
    private LocalDate date;

    @Property ("duration")
    private Duration duration;

    @Property ("flag")
    private String flag;

    @Property ("medium")
    private String medium;

    @Property ("time")
    private LocalTime time;

    @Id @GeneratedValue
    private Long id;

    //Relationship between Person and Call
    @Relationship(type = "RECEIVE_CALL", direction = Relationship.Direction.INCOMING)
    private List<Person> callReceivers;
    //Relationship between Person and Person
    @Relationship(type = "MADE_CALL", direction = Relationship.Direction.OUTGOING)
    private List<Person> callMakers;


    //Getters & setters


    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Duration getDuration() {
        return duration;
    }

    public void setDuration(Duration duration) {
        this.duration = duration;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
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
    public Call() {
    }

    /**
     * Constructor for Call
     *
     * @param date
     * @param duration
     * @param flag
     * @param medium
     * @param time
     */


    public Call( LocalDate date, Duration duration, String flag, String medium, LocalTime time) {
        this.date = date;
        this.duration = duration;
        this.flag = flag;
        this.medium = medium;
        this.time = time;
    }


}
