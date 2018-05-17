package com.example.android.aqua.Models;

/**
 * Created by Aakash on 02-05-2018.
 */

public class Notify {

    public int qualityTurbidity;
    public int usercontrolwater;

    public Notify(){

    }

    public Notify(int qualityTurbidity, int usercontrolwater){
        this.qualityTurbidity = qualityTurbidity;
        this.usercontrolwater = usercontrolwater;
    }
}
