package numbersgenerator;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class NumbersGeneratorRepositoryTestImpl implements NumbersGeneratorRepository {

    Map<LocalDateTime, List<Integer>> database = new ConcurrentHashMap<>();

    @Override
    public void save(WinningNumbers winningNumbers) {
        database.put(winningNumbers.date, winningNumbers.numbers);
    }
}
