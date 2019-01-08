package org.fasttrackit.bloodpressuremanager.domain;

import javax.persistence.*;
import java.io.Serializable;

/**
 * BloodPressure object:
 * -contains: BloodPressure's id, sbp (systolic blood pressure-the high value), dbp (diastolic blood pressure-the low value),
 * pulse, date, hour, minutes, userId and bpNotes
 * <p>
 * -mandatory for repository: - only idBloodPressure, and userId fields must NOT be null for the repository
 * -  id_bp_pk is primary key (idBloodPressure)
 * -  user_id_fk is foreign key for id_user_pk from users table
 * <p>
 * -ex: idBloodPressure  = 1, sbp = "125", dbp= "67", pulse= 76, date = 15.05.2018, hour = "09, minutes = "35",
 * bpUserId = "2" and bpNotes = "after 1 cup of coffee"
 */

@Entity
@Table(name = "blood_pressures")
public class BloodPressure implements Serializable {

    @Id
    @Column(name = "id_bp_pk")
    @GeneratedValue(generator = "bloodPressure_generator")
    @SequenceGenerator(
            name = "bloodPressure_generator",
            sequenceName = "bloodPressure_sequence",
            initialValue = 1
    )
    private Long idBloodPressure;

    @Column(name = "sbp")
    private Integer sbp; //systolic blood pressure (the high value)

    @Column(name = "dbp")
    private Integer dbp; //diastolic blood pressure (the low value)

    @Column(name = "pulse")
    private Integer pulse;

    //TODO change it to date  !!!!!!!!!!!!!!!!!!!!!
    @Column(name = "date")
    private String date;

    //TODO should the hour and minutes be one variable? if yes which type? !!!!!!!!!!!!!!
    @Column(name = "hour")
    private Integer hour;

    @Column(name = "minutes")
    private Integer minutes;

    //TODO not shore if this is ok. !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//TODO (I want to have a field which contains the user's id, not sure if the type should be "User" or Integer)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // many blood pressures to one user
    @JoinColumn(name = "bp_user_id_fk")
    private User bpUser;

    @Column(name = "bp_notes")
    private String bpNotes;

    public Long getIdBloodPressure() {
        return idBloodPressure;
    }

    public void setIdBloodPressure(Long idBloodPressure) {
        this.idBloodPressure = idBloodPressure;
    }

    public Integer getSbp() {
        return sbp;
    }

    public void setSbp(Integer sbp) {
        this.sbp = sbp;
    }

    public Integer getDbp() {
        return dbp;
    }

    public void setDbp(Integer dbp) {
        this.dbp = dbp;
    }

    public Integer getPulse() {
        return pulse;
    }

    public void setPulse(Integer pulse) {
        this.pulse = pulse;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Integer getHour() {
        return hour;
    }

    public void setHour(Integer hour) {
        this.hour = hour;
    }

    public Integer getMinutes() {
        return minutes;
    }

    public void setMinutes(Integer minutes) {
        this.minutes = minutes;
    }

    public User getBpUser() {
        return bpUser;
    }

    public void setBpUser(User bpUser) {
        this.bpUser = bpUser;
    }

    public String getBpNotes() {
        return bpNotes;
    }

    public void setBpNotes(String bpNotes) {
        this.bpNotes = bpNotes;
    }
}
