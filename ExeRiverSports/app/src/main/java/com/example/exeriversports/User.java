package com.example.exeriversports;

// This declares the class 'User'
public class User {

    // This declares the String variable 'Email'
    String Email;

    // This declares the callable 'User' method which sets the value of the users email as the alternate variable 'Email'.
    public User(String Email){
        this.Email = Email;
    }

    // This declares the callable 'getEmail' method which returns the value of the users email.
    public String getEmail() {
        return Email;
    }

    // This declares the callable 'setEmail' method which sets the value of the users email.
    public void setEmail(String Email) {
        this.Email = Email;
    }
}