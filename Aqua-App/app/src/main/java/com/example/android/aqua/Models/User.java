package com.example.android.aqua.Models;

/**
 * Created by Aakash on 03-04-2018.
 */

import com.google.firebase.database.IgnoreExtraProperties;

@IgnoreExtraProperties
public class User {
    public String email;
    public String password;
    public Long phone;
    public String sex;

    public User() {
        // Default constructor required for calls to DataSnapshot.getValue(User.class)
    }

    public User(String email, String password, Long phone, String gender) {
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.sex = gender;
    }
}
