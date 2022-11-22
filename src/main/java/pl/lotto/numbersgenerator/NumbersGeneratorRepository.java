package pl.lotto.numbersgenerator;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
interface NumbersGeneratorRepository extends MongoRepository<WinningNumbers, Long> {

    WinningNumbers save(WinningNumbers winningNumbers);

    List<WinningNumbers> findAll();


}
