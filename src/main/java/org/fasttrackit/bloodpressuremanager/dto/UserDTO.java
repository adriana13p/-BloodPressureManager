package org.fasttrackit.bloodpressuremanager.dto;

public class UserDTO {
    private long idUserDto;
    private String userNameDto;
    private String passwordDTO;


    public UserDTO() {

    }

    public UserDTO(String userNameDto) {
        this.userNameDto = userNameDto;
    }

    public UserDTO(String userNameDto, String passwordDTO) {
        this.userNameDto = userNameDto;
        this.passwordDTO = passwordDTO;
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

    public String getPasswordDTO() {
        return passwordDTO;
    }

    public void setPasswordDTO(String passwordDTO) {
        this.passwordDTO = passwordDTO;
    }

    @Override
    public String toString() {
        return "UserDTO{" +
                "user id=" + idUserDto +
                ",user name='" + userNameDto + '\'' +
                '}';
    }
}
