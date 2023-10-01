package mscproject.cartelapp.DTO;



/**
 * This class is a Data Transfer Object used to store and encapsulate data related to operations with Person Nodes.
 *
 * @author eruizt01
 */

public class PersonDTO {
    private String name;

    private String surname;


    private Integer age;

    private String role;

    private String email_account;

    private String phone_number;

    private Long id;


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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "PersonDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                ", role='" + role + '\'' +
                ", email_account='" + email_account + '\'' +
                ", phone_number='" + phone_number + '\'' +
                ", id=" + id +
                '}';
    }
}
