package org.fasttrackit.bloodpressuremanager.domain;

import javax.persistence.*;
import java.io.Serializable;

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
    @Column(name = "id_user_pk")
    @GeneratedValue(generator = "user_generator")
    @SequenceGenerator(
            name = "user_generator",
            sequenceName = "user_sequence",
            initialValue = 1
    )
    private Long idUser;

    @Column(name = "user_name", unique = true)
    private String userName;

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
}
