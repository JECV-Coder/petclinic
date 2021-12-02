package org.springframework.samples.petclinic.user;

import org.springframework.samples.petclinic.model.Person;
import org.springframework.samples.petclinic.owner.Owner;

import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name = "users")
public class User extends Person {
    @Column(name = "email", unique = true)
    @NotEmpty
    @Email
    private String email;

    @Column(name = "password")
    @NotEmpty
    private String password;

    @Column(name = "telephone")
    @Size(min = 0, max = 10)
    private String telephone;

    @Column(name = "active")
    @NotEmpty
    @Max(1)
    private String active;

    @Column(name = "zipcode")
    @NotEmpty
    @Size(min = 5, max = 10)
    private String zipcode;

    @Column(name = "city")
    @NotEmpty
    private String city;

    /////////////////kevin
    @OneToOne
    @PrimaryKeyJoinColumn
    private Owner owner;
    ///////////////

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_roles",
            joinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "role_id", referencedColumnName = "id"))
    private Collection<Role> roles;

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTelephone() {
        return this.telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getActive() {
        return this.active;
    }

    public boolean isEnabled() {
        if(this.active.compareTo("1") == 0){
            return true;
        }
        return false;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getZipcode() {
        return this.zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCity() {
        return this.city;
    }
}
