package org.fasttrackit.bloodpressuremanager.dto;

public class UserDTO {
    private long idUserDto;
    private String userNameDto;

    public UserDTO(String userNameDto) {
        this.userNameDto = userNameDto;
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

    @Override
    public String toString() {
        return "UserDTO{" +
                "user id=" + idUserDto +
                ",user name='" + userNameDto + '\'' +
                '}';
    }
}
