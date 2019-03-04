package org.fasttrackit.bloodpressuremanager.dto;

public class UserDTO {
    private long idUser;
    private String userName;
    private String password;

    public UserDTO() {

    }

    public UserDTO(String userName) {
        this.userName = userName;
    }

    public UserDTO(String userName, String password) {
        this.userName = userName;
        this.password = password;
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

    @Override
    public String toString() {
        return "UserDTO{" +
                "user id=" + idUser +
                ",user name='" + userName + '\'' +
                '}';
    }
}
