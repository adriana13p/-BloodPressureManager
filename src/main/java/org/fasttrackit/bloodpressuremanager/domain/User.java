package org.fasttrackit.bloodpressuremanager.domain;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * User object:
 * - contains: user's id and name
 * <p>
 * -mandatory for repository: - only id and name  fields must NOT be null for the repository
 * - id_pk is primary key (idUser)
 * <p>
 * -ex: idUser = 1, userName = "Adriana01"
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
    @JoinColumn(name = "user_id")
    private UserDetails userDetailsr;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
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

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("idUser=").append(idUser);
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", userDetailsr=").append(userDetailsr);
        sb.append(", bloodPressures=").append(bloodPressures);
        sb.append('}');
        return sb.toString();
    }
}
