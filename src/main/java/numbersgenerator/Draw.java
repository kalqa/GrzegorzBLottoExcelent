package numbersgenerator;

import java.time.Clock;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

class Draw {
    private static final int RANGE_MAX = 99;
    private static final int AMOUNT_OF_NUMBERS = 6;

    private final Clock clock;

    public Draw(Clock clock) {
        this.clock = clock;
    }

    WinningNumbers startDrew() {
            return new WinningNumbers(LocalDateTime.now(clock).minusHours(1), generateNumbers());
    }

    private List<Integer> generateNumbers() {
        Random rng = new Random();
        Set<Integer> generated = new HashSet<>();
        while (generated.size() < AMOUNT_OF_NUMBERS) {
            Integer next = rng.nextInt(RANGE_MAX) + 1;
            generated.add(next);
        }
        return generated.stream()
                .sorted()
                .toList();
    }

//    private void drawSchedule() {
//        Date alarmTime = createTimer();
//        Timer timer = new Timer();
//
//        timer.schedule(new TimerTask() {
//            @Override
//            public void run() {
//                System.out.println(generateNumbers());
//            }
//        }, alarmTime);
//    }
//
//    Date createTimer() {
//        Calendar calendar = Calendar.getInstance();
//        calendar.set(Calendar.DAY_OF_WEEK, drawDate.getDayOfWeek().getValue());
//        calendar.set(Calendar.HOUR_OF_DAY, drawDate.getHour());
//        calendar.set(Calendar.MINUTE, drawDate.getMinute());
//        calendar.set(Calendar.SECOND, drawDate.getSecond());
//        return calendar.getTime();
//    }


}
