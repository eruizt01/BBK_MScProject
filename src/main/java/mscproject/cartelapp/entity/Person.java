package mscproject.cartelapp.entity;

import org.springframework.data.neo4j.core.schema.*;

import java.util.List;

/**
 * @Node annotation defines the class as a node ("Person")
 * Executives in the respective Firms
 *
 * @author eruizt01
 */

    @Node (labels = {"Person"})
    public class Person {

    //Properties

    @Property ("name")
    private String name;

    @Property ("surname")
    private String surname;

    @Property ("age")
    private Integer age;

    @Property ("role")
    private String role;

    @Property ("email_account")
    private String email_account;

    @Property ("phone_number")
    private String phone_number;

    @Id @GeneratedValue
    private Long id;

    /*//Relationship between Person and Firm
    @Relationship(type = "WORKS", direction = Relationship.Direction.OUTGOING)
    //One to one relationship, we need not create a List of Firms
    private Firm firm;

    //Relationship between Person and Person
    @Relationship(type = "MANAGES", direction = Relationship.Direction.OUTGOING)
    private List<Person> personList;*/



    //Getters & setters

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail_account() {
        return email_account;
    }

    public void setEmail_account(String email_account) {
        this.email_account = email_account;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }


    public long getId() {
        return id;
    }


    //Default constructor
    public Person() {
    }

    /**
     * Constructor for Person
     *
     * @param name
     * @param surName
     * @param age
     * @param role
     * @param email_account
     * @param phone_number
     */
    public Person (String name, String surName, Integer age, String role, String email_account, String phone_number) {
        this.name = name;
        this.surname = surName;
        this.age = age;
        this.role = role;
        this.email_account = email_account;
        this.phone_number = phone_number;
    }



}
