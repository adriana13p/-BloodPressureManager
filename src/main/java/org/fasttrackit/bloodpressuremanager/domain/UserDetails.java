package org.fasttrackit.bloodpressuremanager.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * UserDetails object:
 * -contains: persons's id, firs name, second name, age, gender and notes
 * <p>
 * -mandatory for repository: - only id first name and second name fields must NOT be null for the repository
 * - id_pk is primary key (idDetails)
 * <p>
 * -ex: idDetails = 1, firstName = "Precup", secondName ="Adriana"
 * -ex: idDetails = 1, firstName = "Precup", secondName ="Adriana", age = "33", gender = "F", notes = "no medication"
 */
@Entity
@Table(name = "users_details")
public class UserDetails implements Serializable {

    @Id
    @Column(name = "id_details_pk")
    @GeneratedValue(generator = "details_generator")
    @SequenceGenerator(
            name = "details_generator",
            sequenceName = "details_sequence",
            initialValue = 1
    )
    private Long idDetails;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "second_name")
    private String secondName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private char gender;

    @Column(name = "notes")
    private String notes;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // many blood pressures to one user
    @JoinColumn(name = "user_id_fk")
    private User user;

    public Long getIdDetails() {
        return idDetails;
    }

    public void setIdDetails(Long idDetails) {
        this.idDetails = idDetails;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
