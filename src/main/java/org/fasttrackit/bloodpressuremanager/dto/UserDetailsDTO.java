package org.fasttrackit.bloodpressuremanager.dto;

public class UserDetailsDTO {
    private long idDetailsDto;
    private String firstNameDto;
    private String secondNameDto;
    private Integer ageDto;
    private char genderDto;
    private String notesDto;

    public UserDetailsDTO() {
    }

    public UserDetailsDTO(String firstNameDto, String secondNameDto) {
        this.firstNameDto = firstNameDto;
        this.secondNameDto = secondNameDto;
    }

    public UserDetailsDTO(long idDetailsDto, String firstNameDto, String secondNameDto, Integer ageDto, char genderDto, String notesDto) {
        this.idDetailsDto = idDetailsDto;
        this.firstNameDto = firstNameDto;
        this.secondNameDto = secondNameDto;
        this.ageDto = ageDto;
        this.genderDto = genderDto;
        this.notesDto = notesDto;
    }

    public long getIdDetailsDto() {
        return idDetailsDto;
    }

    public void setIdDetailsDto(long idDetailsDto) {
        this.idDetailsDto = idDetailsDto;
    }

    public String getFirstNameDto() {
        return firstNameDto;
    }

    public void setFirstNameDto(String firstNameDto) {
        this.firstNameDto = firstNameDto;
    }

    public String getSecondNameDto() {
        return secondNameDto;
    }

    public void setSecondNameDto(String secondNameDto) {
        this.secondNameDto = secondNameDto;
    }

    public Integer getAgeDto() {
        return ageDto;
    }

    public void setAgeDto(Integer ageDto) {
        this.ageDto = ageDto;
    }

    public char getGenderDto() {
        return genderDto;
    }

    public void setGenderDto(char genderDto) {
        this.genderDto = genderDto;
    }

    public String getNotesDto() {
        return notesDto;
    }

    public void setNotesDto(String notesDto) {
        this.notesDto = notesDto;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("UserDetailsDTO{");
        sb.append("idDetailsDto=").append(idDetailsDto);
        sb.append(", firstNameDto='").append(firstNameDto).append('\'');
        sb.append(", secondNameDto='").append(secondNameDto).append('\'');
        sb.append(", ageDto=").append(ageDto);
        sb.append(", genderDto=").append(genderDto);
        sb.append(", notesDto='").append(notesDto).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
