package org.fasttrackit.bloodpressuremanager.dto;

import java.util.Date;

public class BloodPressureDTO {

    private long idBP;
    private Integer systolicBP; //systolic blood pressure (the high value)
    private Integer diastolicBP; //diastolic blood pressure (the low value)
    private Integer pulseBP;
    private Date dateBP;
    private String notesBP;
    private long idUser;


    public long getIdBP() {
        return idBP;
    }

    public void setIdBP(long idBP) {
        this.idBP = idBP;
    }

    public Integer getSystolicBP() {
        return systolicBP;
    }

    public void setSystolicBP(Integer systolicBP) {
        this.systolicBP = systolicBP;
    }

    public Integer getDiastolicBP() {
        return diastolicBP;
    }

    public void setDiastolicBP(Integer diastolicBP) {
        this.diastolicBP = diastolicBP;
    }

    public Integer getPulseBP() {
        return pulseBP;
    }

    public void setPulseBP(Integer pulseBP) {
        this.pulseBP = pulseBP;
    }

    public Date getDateBP() {
        return dateBP;
    }

    public void setDateBP(Date dateBP) {
        this.dateBP = dateBP;
    }

    public String getNotesBP() {
        return notesBP;
    }

    public void setNotesBP(String notesBP) {
        this.notesBP = notesBP;
    }

    public long getIdUser() {
        return idUser;
    }

    public void setIdUser(long idUser) {
        this.idUser = idUser;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BloodPressureDTO{");
        sb.append("idBP=").append(idBP);
        sb.append(", systolicBP=").append(systolicBP);
        sb.append(", diastolicBP=").append(diastolicBP);
        sb.append(", pulseBP=").append(pulseBP);
        sb.append(", dateBP=").append(dateBP);
        sb.append(", notesBP='").append(notesBP).append('\'');
        sb.append(", idUser=").append(idUser);
        sb.append('}');
        return sb.toString();
    }
}
