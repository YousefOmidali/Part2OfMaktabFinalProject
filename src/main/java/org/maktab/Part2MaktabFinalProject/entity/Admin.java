package org.maktab.Part2MaktabFinalProject.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.maktab.Part2MaktabFinalProject.entity.base.Users;

import javax.persistence.Entity;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
public class Admin extends Users {



    public Admin(String firstname, String lastname, String email, String username, String password, UserStatus userStatus, String signUpTime) {
        super(firstname, lastname, email, username, password, userStatus, signUpTime);
    }

    public Admin(String username, String password) {
        super(username, password);
    }

    public String toString() {
        return "Admin{" +
                "id='" + getId() + '\'' +
                ", username='" + getUsername() + '\'' +
                ", password='" + getPassword() + '\'' +
                ", firstname='" + getFirstname() + '\'' +
                ", lastname='" + getLastname() + '\'' +
                ", email='" + getEmail() + '\'' +
                ", status='" + this.getUserStatus() + '\'' +
                ", signUptime='" + getSignUpTime() + '\'' +
                '}';
    }
}
