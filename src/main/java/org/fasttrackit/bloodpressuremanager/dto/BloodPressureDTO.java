package org.fasttrackit.bloodpressuremanager.dto;

import org.fasttrackit.bloodpressuremanager.domain.User;

import java.util.Date;

public class BloodPressureDTO {

    private Long idBloodPressureDto;
    private Integer sbpDto; //systolic blood pressure (the high value)
    private Integer dbpDto; //diastolic blood pressure (the low value)
    private Integer pulseDto;
    private Date dateDto;

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

    public Date getDateDto() {
        return dateDto;
    }

    public void setDateDto(Date dateDto) {
        this.dateDto = dateDto;
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
                ", user id =" + userDto.getIdUser() +
                '}';
    }
}
