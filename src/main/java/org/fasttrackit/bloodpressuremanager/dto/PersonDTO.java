package org.fasttrackit.bloodpressuremanager.dto;

public class PersonDTO {
    private long idPersonDto;
    private String personFirstNameDto;
    private String personSecondNameDto;
    private Integer ageDto;
    private char genderDto;
    private String notesDto;

    public PersonDTO(String personFirstNameDto, String personSecondNameDto) {
        this.personFirstNameDto = personFirstNameDto;
        this.personSecondNameDto = personSecondNameDto;
    }

    public long getIdPersonDto() {
        return idPersonDto;
    }

    public void setIdPersonDto(long idPersonDto) {
        this.idPersonDto = idPersonDto;
    }

    public String getPersonFirstNameDto() {
        return personFirstNameDto;
    }

    public void setPersonFirstNameDto(String personFirstNameDto) {
        this.personFirstNameDto = personFirstNameDto;
    }

    public String getPersonSecondNameDto() {
        return personSecondNameDto;
    }

    public void setPersonSecondNameDto(String personSecondNameDto) {
        this.personSecondNameDto = personSecondNameDto;
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
        return "PersonDTO{" +
                "person id=" + idPersonDto +
                ", person name='" + personFirstNameDto + " " + personSecondNameDto + '\'' +
                '}';
    }
}
