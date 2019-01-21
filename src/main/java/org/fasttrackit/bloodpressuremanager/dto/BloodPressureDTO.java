package org.fasttrackit.bloodpressuremanager.dto;

import java.util.Date;

public class BloodPressureDTO {

    private Long idBPDto;
    private Integer systolicBPDto; //systolic blood pressure (the high value)
    private Integer diastolicBPDto; //diastolic blood pressure (the low value)
    private Integer pulseBPDto;
    private Date dateBPDto;

    private String notesBPDto;

    public Long getIdBPDto() {
        return idBPDto;
    }

    public void setIdBPDto(Long idBPDto) {
        this.idBPDto = idBPDto;
    }

    public Integer getSystolicBPDto() {
        return systolicBPDto;
    }

    public void setSystolicBPDto(Integer systolicBPDto) {
        this.systolicBPDto = systolicBPDto;
    }

    public Integer getDiastolicBPDto() {
        return diastolicBPDto;
    }

    public void setDiastolicBPDto(Integer diastolicBPDto) {
        this.diastolicBPDto = diastolicBPDto;
    }

    public Integer getPulseBPDto() {
        return pulseBPDto;
    }

    public void setPulseBPDto(Integer pulseBPDto) {
        this.pulseBPDto = pulseBPDto;
    }

    public Date getDateBPDto() {
        return dateBPDto;
    }

    public void setDateBPDto(Date dateBPDto) {
        this.dateBPDto = dateBPDto;
    }

    public String getNotesBPDto() {
        return notesBPDto;
    }

    public void setNotesBPDto(String notesBPDto) {
        this.notesBPDto = notesBPDto;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BloodPressureDTO{");
        sb.append("idBPDto=").append(idBPDto);
        sb.append(", systolicBPDto=").append(systolicBPDto);
        sb.append(", diastolicBPDto=").append(diastolicBPDto);
        sb.append(", pulseBPDto=").append(pulseBPDto);
        sb.append(", dateBPDto=").append(dateBPDto);
        sb.append(", notesBPDto='").append(notesBPDto).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
