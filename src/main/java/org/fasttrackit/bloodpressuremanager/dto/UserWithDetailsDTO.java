package org.fasttrackit.bloodpressuremanager.dto;

public class UserWithDetailsDTO {
    private long idUser;
    private String userName;
    private String password;
    private long idDetails;
    private String firstName;
    private String secondName;
    private Integer age;
    private char gender;
    private String notes;

    public UserWithDetailsDTO(String userName) {
        this.userName = userName;
    }

    public UserWithDetailsDTO(long idUser, String userName, String password, long idDetails, String firstName, String secondName, Integer age, char gender, String notes) {
        this.idUser = idUser;
        this.userName = userName;
        this.password = password;
        this.idDetails = idDetails;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.gender = gender;
        this.notes = notes;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getIdDetails() {
        return idDetails;
    }

    public void setIdDetails(long idDetails) {
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
}
