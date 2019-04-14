package com.stormy.studios.util;

import squidpony.squidmath.RNG;

public class Random {

    private static RNG rng = new RNG();

    public static boolean chance(double chance) {
        return rng.between(0.0, 100.0) < chance;
    }
}
