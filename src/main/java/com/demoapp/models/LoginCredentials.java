package com.demoapp.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LoginCredentials {

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    // getter and setter methods
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }
    public void setPassword(String password){
        this.password = password;
    }

    @Override
    public String toString() {
        return "LoginCredentials{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
