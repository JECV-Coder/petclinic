package org.springframework.samples.petclinic.user;

import org.springframework.samples.petclinic.model.Person;
import org.springframework.samples.petclinic.owner.OwnerDTO;

public class UserDTO {

    private String user;
    private String pwd;
    private String token;

    private OwnerDTO owner;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public OwnerDTO getOwner() {
        return owner;
    }

    public void setOwner(OwnerDTO owner) {
        this.owner = owner;
    }
}
