package pl.lotto.numberreceiver;

import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.FluentQuery;

import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class NumbersInputRepositoryTestImpl implements NumbersInputRepository {

    Map<UUID, LotteryTicket> database = new ConcurrentHashMap<>();

    @Override
    public LotteryTicket save(LotteryTicket lotteryTicket) {
        database.put(lotteryTicket.uuid, lotteryTicket);
        return null;
    }

    @Override
    public List<LotteryTicket> findAllByNearestDrawDate(LocalDateTime date) {
        return database.values()
                .stream()
                .filter(lotteryTicket -> lotteryTicket.nearestDrawDate.isEqual(date))
                .collect(Collectors.toList());
    }

    @Override
    public <S extends LotteryTicket> List<S> saveAll(Iterable<S> entities) {
        return null;
    }

    @Override
    public Optional<LotteryTicket> findById(UUID uuid) {
        return Optional.empty();
    }

    @Override
    public boolean existsById(UUID uuid) {
        return false;
    }

    @Override
    public List<LotteryTicket> findAll() {
        return new ArrayList<>(database.values());
    }

    @Override
    public Iterable<LotteryTicket> findAllById(Iterable<UUID> uuids) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }

    @Override
    public void deleteById(UUID uuid) {

    }

    @Override
    public void delete(LotteryTicket entity) {

    }

    @Override
    public void deleteAllById(Iterable<? extends UUID> uuids) {

    }

    @Override
    public void deleteAll(Iterable<? extends LotteryTicket> entities) {

    }

    @Override
    public void deleteAll() {

    }

    @Override
    public List<LotteryTicket> findAll(Sort sort) {
        return null;
    }

    @Override
    public Page<LotteryTicket> findAll(Pageable pageable) {
        return null;
    }

    @Override
    public <S extends LotteryTicket> S insert(S entity) {
        return null;
    }

    @Override
    public <S extends LotteryTicket> List<S> insert(Iterable<S> entities) {
        return null;
    }

    @Override
    public <S extends LotteryTicket> Optional<S> findOne(Example<S> example) {
        return Optional.empty();
    }

    @Override
    public <S extends LotteryTicket> List<S> findAll(Example<S> example) {
        return null;
    }

    @Override
    public <S extends LotteryTicket> List<S> findAll(Example<S> example, Sort sort) {
        return null;
    }

    @Override
    public <S extends LotteryTicket> Page<S> findAll(Example<S> example, Pageable pageable) {
        return null;
    }

    @Override
    public <S extends LotteryTicket> long count(Example<S> example) {
        return 0;
    }

    @Override
    public <S extends LotteryTicket> boolean exists(Example<S> example) {
        return false;
    }

    @Override
    public <S extends LotteryTicket, R> R findBy(Example<S> example, Function<FluentQuery.FetchableFluentQuery<S>, R> queryFunction) {
        return null;
    }

}
