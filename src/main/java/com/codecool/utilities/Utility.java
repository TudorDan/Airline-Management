package com.codecool.utilities;

import java.util.Random;

public class Utility {
    /**
     * Generates a random number
     * @param min inclusive
     * @param max inclusive
     * @return integer
     */
    public static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
