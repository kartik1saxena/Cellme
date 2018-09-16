package com.tu.cellme;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by hp on 10/1/2017.
 */

public class Cellme extends Application{
    @Override
    public void onCreate(){
        super.onCreate();
        Firebase.setAndroidContext(this);

    }
}
