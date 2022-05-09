package org.maktab.Part2MaktabFinalProject.entity.base;

import lombok.*;
import org.maktab.Part2MaktabFinalProject.entity.Status;

import javax.persistence.Column;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.MappedSuperclass;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@MappedSuperclass
public abstract class Users extends BaseEntity<Long> {
    private String firstname;
    private String lastname;
    @Column(unique = true)
    private String email;
    private String username;
    @Column(nullable = false)
    private String password;
    @Enumerated(EnumType.STRING)
    private Status status;
    private String signUpTime;

    public Users(Long aLong, String firstname, String lastname, String email, String username, String password, Status status, String signUpTime) {
        super(aLong);
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = email;
        this.username = username;
        this.password = password;
        this.status = status;
        this.signUpTime = signUpTime;
    }

    public Users(String username, String password) {
        this.username = username;
        this.password = password;
    }
}
