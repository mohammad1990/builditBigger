package com.example;

import java.util.Random;

public class GetJoke {
    private String[] jokes;
    private Random random;

    public GetJoke() {
        jokes = new String[3];
        jokes[0] = "Doctor I have good news and bad news," +
                " Patient: go with good news, " +
                "Doctor: you have 24 hours to live, " +
                "Patient:how about the bad news " +
                "Doctor: I forgot yo tell you yesterday";
        jokes[1] = "The longest five seconds in anyones life is waiting to press the skip ad button on youtube";
        jokes[2] = "The awkward moment when you run into the wardobe and you dont end up in narnia";
        random = new Random();
    }

    public String[] getJokes() {
        return jokes;
    }

    public String getRandomJoke() {
        return jokes[random.nextInt(jokes.length)];
    }
}
