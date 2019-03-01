package org.fasttrackit.bloodpressuremanager.dto;

import java.util.Date;

public class BloodPressureWithUserNameDTO {
    private long idBP;
    private Integer systolicBP; //systolic blood pressure (the high value)
    private Integer diastolicBP; //diastolic blood pressure (the low value)
    private Integer pulseBP;
    private Date dateBP;
    private String notesBP;
    private String userName;

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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String toString() {
        final StringBuilder sb = new StringBuilder("BloodPressureDTO{");
        sb.append("idBP=").append(idBP);
        sb.append(", systolicBP=").append(systolicBP);
        sb.append(", diastolicBP=").append(diastolicBP);
        sb.append(", pulseBP=").append(pulseBP);
        sb.append(", dateBP=").append(dateBP);
        sb.append(", notesBP='").append(notesBP).append('\'');
        sb.append(", userNae=").append(userName);
        sb.append('}');
        return sb.toString();
    }
}
