package pl.lotto.numberreceiver;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Document
public class LotteryTicket {

    @Id
    UUID uuid;
    LocalDateTime nearestDrawDate;
    List<Integer> numbersFromUser;

    LotteryTicket(UUID uuid, LocalDateTime nearestDrawDate, List<Integer> numbersFromUser) {
        this.uuid = uuid;
        this.nearestDrawDate = nearestDrawDate;
        this.numbersFromUser = numbersFromUser;
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDateTime getNearestDrawDate() {
        return nearestDrawDate;
    }

    public void setNearestDrawDate(LocalDateTime nearestDrawDate) {
        this.nearestDrawDate = nearestDrawDate;
    }

    public List<Integer> getNumbersFromUser() {
        return numbersFromUser;
    }

    public void setNumbersFromUser(List<Integer> numbersFromUser) {
        this.numbersFromUser = numbersFromUser;
    }

    @Override
    public String toString() {
        return "LotteryTicket{" +
                "uuid=" + uuid +
                ", nearestDrawDate=" + nearestDrawDate +
                ", numbersFromUser=" + numbersFromUser +
                '}';
    }
}
