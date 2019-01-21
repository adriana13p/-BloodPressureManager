package org.fasttrackit.bloodpressuremanager.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User object:
 * - contains: user's id , name password, user details ans a list of blood pressures
 * <p>
 * -mandatory for repository: - only id and name  fields must NOT be null for the repository
 * - id_user is primary key (idUser)
 * "user_details_id_fk" column from "users" table is the foreign key for "users_details" table
 * <p>
 * -ex: idUser = 1, userName = "Adriana01"
 * -ex: idUser = 1, userName = "Adriana01", password = "AdriPass01"
 */

@Entity
@Table(name = "users")
public class User implements Serializable {

    @Id
    @Column(name = "id_user")
    @GeneratedValue(generator = "user_generator")
    @SequenceGenerator(
            name = "user_generator",
            sequenceName = "user_sequence",
            initialValue = 1
    )
    private Long idUser;

    @Column(name = "user_name", unique = true)
    private String userName;

    @Column(name = "password")
    private String password;

    @OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL) // one user to one user details
    @JoinColumn(name = "user_details_id_fk")
    //"users" table is the one that contains the foreign key to "users_details" table
    //("user_details_id_fk" column from "users" table is the foreign key)
    private UserDetails userDetails;


    @OneToMany(mappedBy = "blood_pressures", cascade = CascadeType.ALL) //many blood pressures to one user
    //"blood_pressures" table is the one that contains the foreign key to "users" table
    //("user_id_fk column from "blood_pressures" table is the foreign key)
    private List<BloodPressure> bloodPressures = new ArrayList<>();


    public Long getIdUser() {
        return idUser;
    }

    public void setIdUser(Long idUser) {
        this.idUser = idUser;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserDetails getUserDetails() {
        return userDetails;
    }

    public void setUserDetails(UserDetails userDetails) {
        this.userDetails = userDetails;
    }

    public List<BloodPressure> getBloodPressures() {
        return bloodPressures;
    }

    public void setBloodPressures(List<BloodPressure> bloodPressures) {
        this.bloodPressures = bloodPressures;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("idUser=").append(idUser);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", password='").append(password).append('\'');
        sb.append(", userDetails=").append(userDetails);
        sb.append(", bloodPressures=").append(bloodPressures);
        sb.append('}');
        return sb.toString();
    }
}
