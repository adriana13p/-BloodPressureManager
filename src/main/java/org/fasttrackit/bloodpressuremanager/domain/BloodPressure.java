package org.fasttrackit.bloodpressuremanager.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

/**
 * BloodPressure object:
 * -contains: BloodPressure's id, systolicBP (systolic blood pressure-the high value), diastolicBP (diastolic blood pressure-the low value),
 * pulseBP, dateBP, hour, minutes, userId and notes_BP
 * <p>
 * -mandatory for repository: - only idBP, and userId fields must NOT be null for the repository
 * -  id_bp_pk is primary key (idBP)
 * -  user_id_fk is foreign key for id_user_pk from users table
 * <p>
 * -ex: idBP  = 1, systolicBP = "125", diastolicBP= "67", pulseBP= 76, dateBP = 15.05.2018 13:25
 *      bpUserId = "2" and notes_BP = "after 1 cup of coffee"
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
    private Long idBP;

    @Column(name = "systolic_bp")
    private Integer systolicBP; //systolic blood pressure (the high value)

    @Column(name = "diastolic_bp")
    private Integer diastolicBP; //diastolic blood pressure (the low value)

    @Column(name = "pulse_bp")
    private Integer pulseBP;

    @Column(name = "date_bp")
    private Date dateBP;  //contains the day, month, year , hours and minutes

    @Column(name = "notes_bp")
    private String notes_BP;

/*

    //TODO not shore if this is ok. !!!!!!!!!!!!!!!!!!!!!!!!!!!!!
//TODO (I want to have a field which contains the user's id, not sure if the type should be "User" or Integer)
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // many blood pressures to one user
    @JoinColumn(name = "bp_user_id_fk")
    private User bpUser;
*/


    public Long getIdBP() {
        return idBP;
    }

    public void setIdBP(Long idBP) {
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

    public String getNotes_BP() {
        return notes_BP;
    }

    public void setNotes_BP(String notes_BP) {
        this.notes_BP = notes_BP;
    }

       /* public User getBpUser() {
        return bpUser;
    }

    public void setBpUser(User bpUser) {
        this.bpUser = bpUser;
    }
*/

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("BloodPressure{");
        sb.append("idBP=").append(idBP);
        sb.append(", systolicBP=").append(systolicBP);
        sb.append(", diastolicBP=").append(diastolicBP);
        sb.append(", pulseBP=").append(pulseBP);
        sb.append(", dateBP=").append(dateBP);
        sb.append(", notes_BP='").append(notes_BP).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
