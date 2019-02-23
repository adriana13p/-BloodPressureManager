package org.fasttrackit.bloodpressuremanager.dto;

public class UserDTO {
    private long idUserDto;
    private String userNameDto;
    private String passwordDto;

    public UserDTO() {

    }

    public UserDTO(String userNameDto) {
        this.userNameDto = userNameDto;
    }

    public UserDTO(String userNameDto, String passwordDto) {
        this.userNameDto = userNameDto;
        this.passwordDto = passwordDto;
    }

    public long getIdUserDto() {
        return idUserDto;
    }

    public void setIdUserDto(long idUserDto) {
        this.idUserDto = idUserDto;
    }

    public String getUserNameDto() {
        return userNameDto;
    }

    public void setUserNameDto(String userNameDto) {
        this.userNameDto = userNameDto;
    }

    public String getPasswordDto() {
        return passwordDto;
    }

    public void setPasswordDto(String passwordDto) {
        this.passwordDto = passwordDto;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "user id=" + idUserDto +
                ",user name='" + userNameDto + '\'' +
                '}';
    }
}
