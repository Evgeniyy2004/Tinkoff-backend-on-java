package edu.hw11;

import org.jetbrains.annotations.NotNull;
import static java.lang.Integer.parseInt;

public class TestClass {
    private static final int SECONDS_IN_MINUTE = 60;

    public int minutesToSeconds(@NotNull  String video) {
        String[] minutesSec = String.join("", video.split(" ")).split(":");
        if (minutesSec.length != 2) {
            return -1;
        }


        try {
            int minutes = parseInt(minutesSec[0]);
            int seconds = parseInt(minutesSec[1]);
            if (seconds >= SECONDS_IN_MINUTE || seconds < 0 || minutes < 0) {
                return -1;
            }
            return minutes * SECONDS_IN_MINUTE + seconds;
        } catch (NumberFormatException e) {
            return -1;
        }
    }

    public static int staticCount(@NotNull  String video) {
        String[] minutesSec = String.join("", video.split(" ")).split(":");
        if (minutesSec.length != 2) {
            return -1;
        }


        try {
            int minutes = parseInt(minutesSec[0]);
            int seconds = parseInt(minutesSec[1]);
            if (seconds >= SECONDS_IN_MINUTE || seconds < 0 || minutes < 0) {
                return -1;
            }
            return minutes * SECONDS_IN_MINUTE + seconds;
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}
