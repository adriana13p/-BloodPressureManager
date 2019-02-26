package org.fasttrackit.bloodpressuremanager.dto;

public class UserDetailsDTO {
    private long idDetails;
    private String firstName;
    private String secondName;
    private Integer age;
    private char gender;
    private String notes;
    private long idUser;

    public UserDetailsDTO() {
    }


    public UserDetailsDTO(String firstName, String secondName) {
        this.firstName = firstName;
        this.secondName = secondName;
    }

    public UserDetailsDTO(long idDetails, String firstName, String secondName, Integer age, char gender, String notes, long idUser) {
        this.idDetails = idDetails;
        this.firstName = firstName;
        this.secondName = secondName;
        this.age = age;
        this.gender = gender;
        this.notes = notes;
        this.idUser = idUser;
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

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDetailsDTO{");
        sb.append("idDetails=").append(idDetails);
        sb.append(", firstName='").append(firstName).append('\'');
        sb.append(", secondName='").append(secondName).append('\'');
        sb.append(", age=").append(age);
        sb.append(", gender=").append(gender);
        sb.append(", notes='").append(notes).append('\'');
        sb.append(", idUser=").append(idUser);
        sb.append('}');
        return sb.toString();
    }
}
