package com.example.android.aqua.Models;

import com.google.firebase.database.IgnoreExtraProperties;

/**
 * Created by Aakash on 30-04-2018.
 */

@IgnoreExtraProperties
public class object {

    public float Time;
    public float Value;

    public object(){

    }

    public object(float time, float value){
        this.Time = time;
        this.Value = value;
    }
}
