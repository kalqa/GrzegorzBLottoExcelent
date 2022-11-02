package pl.lotto.numberreceiver;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

public class DrawDatesFinder {

    public static final DayOfWeek DRAW_DAY_OF_WEEK = DayOfWeek.SATURDAY;
    public static final int DRAW_HOUR = 12;
    public static LocalDateTime TICKET_DATE = LocalDateTime.now();

    public static LocalDateTime upcomingDrawDate() {
        if (TICKET_DATE.getHour() < DRAW_HOUR) {
            return TICKET_DATE.with(TemporalAdjusters.nextOrSame(DRAW_DAY_OF_WEEK));
        } else {
            return TICKET_DATE.with(TemporalAdjusters.next(DRAW_DAY_OF_WEEK));
        }
    }



}
