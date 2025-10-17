package org.example.util;

public class MathHelper {
    public static final double PI = 3.141592653589793;
    public static final double EPS = 1e-9;

    public static boolean epsilonEqual(double a, double b) {
        return Math.abs(a-b) < EPS;
    }
    public static double round(double value, int places) {
        double scale = Math.pow(10, places);
        return Math.round(value * scale) / scale;
    }
}
