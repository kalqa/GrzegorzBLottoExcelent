package pl.lotto.numberreceiver;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class NumbersInputRepositoryTestImpl implements NumbersInputRepository {

    Map<UUID, LotteryTicket> database = new ConcurrentHashMap<>();

    @Override
    public void save(LotteryTicket lotteryTicket) {
        database.put(lotteryTicket.uuid, lotteryTicket);
    }
}
