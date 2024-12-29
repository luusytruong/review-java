package week3;

import java.text.MessageFormat;
import java.time.LocalTime;

public class Time {
    public static String now() {
        LocalTime current = LocalTime.now();
        return MessageFormat.format("[{0}:{1}:{2}] ", current.getHour(), current.getMinute(), current.getSecond());
    }
}
