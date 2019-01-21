package com.jeffwang;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


public class Spitter {

    private Long id;

    @NotNull
    @Size(min=2, max=30)
    private String firstName;

    @NotNull
    @Size(min=2, max=30)
    private String lastName;

    @NotNull
    @Size(min=5, max=16)
    private String username;

    @NotNull
    @Size(min=5, max=16)
    private Long password;

    public Spitter(){
        this.id = null;
        this.firstName = null;
        this.lastName = null;
        this.password = null;
        this.username = null;
    }

    public Spitter(String firstName, String lastName, String username, Long password){
        this.id = null;
        this.username = username;
        this.password = password;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Long getId() {
        return id;
    }

    public Long getPassword() {
        return password;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getUsername() {
        return username;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPassword(Long password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}

