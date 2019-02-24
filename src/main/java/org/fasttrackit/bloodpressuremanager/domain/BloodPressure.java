package org.fasttrackit.bloodpressuremanager.domain;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

/**
 * BloodPressure object:
 * -contains: BloodPressure's id, systolicBP (systolic blood pressure-the high value), diastolicBP (diastolic blood pressure-the low value),
 * pulseBP, dateBP, and notesBP, and a user
 * <p>
 * -mandatory for repository: - only idBP, and user_id_fk fields must NOT be null for the repository
 * -  id_bp is primary key (idBP)
 * -  user_id_fk is foreign key for id_user from users table
 * <p>
 * -ex: idBP  = 1, systolicBP = "125", diastolicBP= "67", pulseBP= 76, dateBP = 15.05.2018 13:25
 * bpUserId = "2" and notesBP = "after 1 cup of coffee", user_id_fk ="2"
 */

@Entity
@Table(name = "blood_pressures")
public class BloodPressure implements Serializable {

    @Id
    @Column(name = "id_bp")
    @GeneratedValue(generator = "bloodPressure_generator")
    @SequenceGenerator(
            name = "bloodPressure_generator",
            sequenceName = "bloodPressure_sequence",
            initialValue = 1
    )
    private long idBP;

    @Column(name = "systolic_bp")
    private Integer systolicBP; //systolic blood pressure (the high value)

    @Column(name = "diastolic_bp")
    private Integer diastolicBP; //diastolic blood pressure (the low value)

    @Column(name = "pulse_bp")
    private Integer pulseBP;

    @Column(name = "date_bp")
    private Date dateBP;  //contains the day, month, year , hours and minutes

    @Column(name = "notes_bp")
    private String notesBP;

    @ManyToOne
    @JoinColumn(name = "user_id_fk")
    //"blood_pressures" table is the one that contains the foreign key to "users" table
    //("user_id_fk" column from "blood_pressures" table is the foreign key)
    private @NotNull
    User user;


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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BloodPressure{");
        sb.append("idBP=").append(idBP);
        sb.append(", systolicBP=").append(systolicBP);
        sb.append(", diastolicBP=").append(diastolicBP);
        sb.append(", pulseBP=").append(pulseBP);
        sb.append(", dateBP=").append(dateBP);
        sb.append(", notesBP='").append(notesBP).append('\'');
        sb.append(", user=").append(user);
        sb.append('}');
        return sb.toString();
    }
}
