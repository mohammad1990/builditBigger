package com.example.hamzaK.myapplication.backend;

import com.example.GetJoke;

/**
 * The object model for the data we are sending through endpoints
 */
public class MyBean {
    GetJoke getJoke;

    MyBean() {
        getJoke = new GetJoke();
    }

    public String getJoke() {
        return getJoke.getRandomJoke();
    }

}