package pl.lotto;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import pl.lotto.numberreceiver.NumberReceiverFacade;
import pl.lotto.numberreceiver.NumbersInputRepository;
import pl.lotto.numberreceiver.dto.NumberReceiverResultDto;
import pl.lotto.numbersgenerator.NumbersGeneratorFacade;
import pl.lotto.numbersgenerator.dto.NumbersGeneratorResultDto;

import java.time.DayOfWeek;
import java.time.LocalDateTime;
import java.util.List;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest(classes = LottoGameApplication.class)
@AutoConfigureMockMvc
@Testcontainers
public class ApplicationRunTest {

    @Autowired
    protected MockMvc mockMvc;
    @Autowired
    NumberReceiverFacade numberReceiverFacade;
    @Autowired
    NumbersInputRepository repository;
    @Autowired
    NumbersGeneratorFacade numbersGeneratorFacade;

    @Container
    private static final MongoDBContainer mongoDBContainer = new MongoDBContainer(DockerImageName.parse("mongo:4.0.10"));

    @BeforeAll
    static void initial() {
        mongoDBContainer.start();
    }

    @DynamicPropertySource
    private static void propertyOverride(DynamicPropertyRegistry registry) {
        registry.add("spring.data.mongodb.uri", mongoDBContainer::getReplicaSetUrl);
    }

    @Test
    public void happy_path() throws Exception {
        // given

        // when
        ResultActions perform = mockMvc.perform(MockMvcRequestBuilders.post("/inputNumbers")
//                .content(asJsonString(List.of(1, 2, 3, 4, 5, 6)))
                .content("{\"numbers\": [1,2,3,4,5,6]}")
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
        // then
        perform.andExpect(status().isOk());

        NumberReceiverResultDto numberReceiverResultDto = numberReceiverFacade.inputNumbers(List.of(1, 2, 3, 4, 5, 6));
        String userLotteryID = numberReceiverResultDto.userLotteryId();
        LocalDateTime drewTime = numberReceiverResultDto.drawTime();
        String message = numberReceiverResultDto.message();
        Assertions.assertNotNull(numberReceiverResultDto);
        Assertions.assertEquals("all good", message);
        assert userLotteryID != null;
        assert drewTime.getDayOfWeek() == DayOfWeek.SATURDAY;


        NumbersGeneratorResultDto NumbersGeneratorResultDto = numbersGeneratorFacade.generateNumbers();
//        assert NumbersGeneratorResultDto.drawDate().getDayOfWeek() == DayOfWeek.SATURDAY;
        assert NumbersGeneratorResultDto.numbers().size() == 6;







    }

    public static String asJsonString(final Object obj) {
        try {
            final ObjectMapper mapper = new ObjectMapper();
            final String jsonContent = mapper.writeValueAsString(obj);
            return jsonContent;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
