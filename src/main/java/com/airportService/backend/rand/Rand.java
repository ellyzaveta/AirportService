package com.airportService.backend.rand;

import java.util.Random;

public class Rand {
    private static final Random random = new Random();
    public static String generateFlightNumber() {
        return (char) ('a' + random.nextInt(26)) + String.valueOf((char) ('a' + random.nextInt(26))) +
                randInt(1000, 10000);
    }

    public static String generateTicketNumber() {
        return (char) ('a' + random.nextInt(26)) + String.valueOf((char) ('a' + random.nextInt(26))) +
                String.valueOf((char) ('a' + random.nextInt(26))) + String.valueOf((char) ('a' + random.nextInt(26))) +
                randInt(10000000, 1000000000);
    }

    public static String generateQRCode() {
        return (char) ('a' + random.nextInt(26)) + String.valueOf((char) ('a' + random.nextInt(26))) +
                String.valueOf((char) ('a' + random.nextInt(26))) + String.valueOf((char) ('a' + random.nextInt(26))) +
                randInt(10000000, 1000000000) + (char) ('a' + random.nextInt(26)) + String.valueOf((char) ('a' + random.nextInt(26))) +
                String.valueOf((char) ('a' + random.nextInt(26))) + String.valueOf((char) ('a' + random.nextInt(26)));
    }

    private static int randInt(int min, int max) {
        return random.nextInt((max - min) + 1) + min;
    }
}
