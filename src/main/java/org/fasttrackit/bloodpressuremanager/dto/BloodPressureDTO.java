package org.fasttrackit.bloodpressuremanager.dto;

import org.fasttrackit.bloodpressuremanager.domain.User;

public class BloodPressureDTO {

    private Long idBloodPressureDto;
    private Integer sbpDto; //systolic blood pressure (the high value)
    private Integer dbpDto; //diastolic blood pressure (the low value)
    private Integer pulseDto;

    //TODO change it to date  !!!!!!!!!!!!!!!!!!!!!
    private String dateDto;

    //TODO should the hour and minutes be one variable? if yes which type? !!!!!!!!!!!!!!

    private Integer hourDto;
    private Integer minutesDto;
    private User userDto;
    private String bpNotesDto;

    public Long getIdBloodPressureDto() {
        return idBloodPressureDto;
    }

    public void setIdBloodPressureDto(Long idBloodPressureDto) {
        this.idBloodPressureDto = idBloodPressureDto;
    }

    public Integer getSbpDto() {
        return sbpDto;
    }

    public void setSbpDto(Integer sbpDto) {
        this.sbpDto = sbpDto;
    }

    public Integer getDbpDto() {
        return dbpDto;
    }

    public void setDbpDto(Integer dbpDto) {
        this.dbpDto = dbpDto;
    }

    public Integer getPulseDto() {
        return pulseDto;
    }

    public void setPulseDto(Integer pulseDto) {
        this.pulseDto = pulseDto;
    }

    public String getDateDto() {
        return dateDto;
    }

    public void setDateDto(String dateDto) {
        this.dateDto = dateDto;
    }

    public Integer getHourDto() {
        return hourDto;
    }

    public void setHourDto(Integer hourDto) {
        this.hourDto = hourDto;
    }

    public Integer getMinutesDto() {
        return minutesDto;
    }

    public void setMinutesDto(Integer minutesDto) {
        this.minutesDto = minutesDto;
    }

    public User getUserDto() {
        return userDto;
    }

    public void setUserDto(User userDto) {
        this.userDto = userDto;
    }

    public String getBpNotesDto() {
        return bpNotesDto;
    }

    public void setBpNotesDto(String bpNotesDto) {
        this.bpNotesDto = bpNotesDto;
    }

    @Override
    public String toString() {
        return "BloodPressureDTO{" +
                "blood pressure id =" + idBloodPressureDto +
                ", systolic blood pressure =" + sbpDto +
                ", diastolic blood pressure =" + dbpDto +
                ", pulse=" + pulseDto +
                ", date=" + dateDto +
                ", hour=" + hourDto +
                ", minutes=" + minutesDto +
                ", user id =" + userDto.getIdUser() +
                '}';
    }
}
