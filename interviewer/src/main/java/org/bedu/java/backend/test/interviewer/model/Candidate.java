package org.bedu.java.backend.test.interviewer.model;

import java.io.Serializable;
import java.util.ArrayList;

public class Candidate implements Serializable {
    static ArrayList<Candidate> data;
    Long id;
    String name;
    String lastName;
    String email;
    Boolean isActive;

    public Candidate(String name, String lastName, String email, Boolean isActive) {
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.isActive = isActive;
    }
    public Candidate add(){
        data.add(this);
        return this;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public void save(
            String name,
            String lastName,
            String email,
            Boolean isActive
    ){
        if (!name.equals(""))
            this.name = name;

        if (!lastName.equals(""))
            this.lastName = lastName;

        if (!email.equals(""))
            this.email = email;

        this.isActive = isActive;

        data.add(this);
    }
}
