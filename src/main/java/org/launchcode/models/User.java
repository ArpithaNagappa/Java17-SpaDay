package org.launchcode.models;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class User {
    @NotNull(message = "Username is between 5 and 15 characters")
    @Size(min=5,max=15,message = "Username is between 5 and 15 characters")
    private String username;
    @NotNull
    @Email
    private String email;
    @Size(min=5,message = " password should have at least 6 characters long")
    private String password;
    @Size(min=5,message = " password should have at least 6 characters long")
    private String verify;

    public User() {

    }

    public User(String username, String email, String password,String verify) {
        this();
        this.username = username;
        this.email = email;
        this.password = password;
        this.verify=verify;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public String getVerify() {
        return verify;
    }

    public void setVerify(String verify) {
        this.verify = verify;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    private void checkPassword(){

    }
}

