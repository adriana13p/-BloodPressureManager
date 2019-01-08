package org.fasttrackit.bloodpressuremanager.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Person object:
 * -contains: persons's id, firs name, second name, age, gender and notes
 * <p>
 * -mandatory for repository: - only id first name and second name fields must NOT be null for the repository
 * - id_pk is primary key (idPerson)
 * <p>
 * -ex: idPerson = 1, personFirstName = "Precup", personSecondName ="Adriana"
 * -ex: idPerson = 1, personFirstName = "Precup", personSecondName ="Adriana", age = "33", gender = "F", notes = "no medication"
 */
@Entity
@Table(name = "persons")
public class Person implements Serializable {

    @Id
    @Column(name = "id_person_pk")
    @GeneratedValue(generator = "person_generator")
    @SequenceGenerator(
            name = "person_generator",
            sequenceName = "person_sequence",
            initialValue = 1
    )
    private Long idPerson;

    @Column(name = "person_first_name")
    private String personFirstName;

    @Column(name = "person_second_name")
    private String personSecondName;

    @Column(name = "age")
    private Integer age;

    @Column(name = "gender")
    private char gender;

    @Column(name = "notes")
    private String notes;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // many blood pressures to one user
    @JoinColumn(name = "person_user_id_fk")
    private User personUser;

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public String getPersonFirstName() {
        return personFirstName;
    }

    public void setPersonFirstName(String personFirstName) {
        this.personFirstName = personFirstName;
    }

    public String getPersonSecondName() {
        return personSecondName;
    }

    public void setPersonSecondName(String personSecondName) {
        this.personSecondName = personSecondName;
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

    public User getPersonUser() {
        return personUser;
    }

    public void setPersonUser(User personUser) {
        this.personUser = personUser;
    }
}
