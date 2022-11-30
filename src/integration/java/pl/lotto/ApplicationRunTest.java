package pl.lotto;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.time.Clock;
import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Primary;
import org.springframework.http.MediaType;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.ContentResultMatchers;
import org.testcontainers.containers.MongoDBContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;
import org.testcontainers.utility.DockerImageName;
import pl.lotto.numberreceiver.NumberReceiverFacade;
import pl.lotto.numberreceiver.NumbersInputRepository;
import pl.lotto.numberreceiver.dto.NumberReceiverResultDto;
import pl.lotto.numbersgenerator.NumbersGeneratorFacade;
import pl.lotto.numbersgenerator.dto.NumbersGeneratorResultDto;
import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
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
        // STEP 1 user gave numbers

        // given
        MockHttpServletRequestBuilder postInputNumbers = MockMvcRequestBuilders.post("/inputNumbers");
        // when
        ResultActions resultForInputNumbers = mockMvc.perform(postInputNumbers
                .content(asJsonString(Map.of("numbers", List.of(1, 2, 3, 4, 5, 6))))
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
        // then
        resultForInputNumbers.andExpect(status().isOk());
        String contentAsString = resultForInputNumbers.andReturn().getResponse().getContentAsString();
        assertThat(contentAsString).contains("\"drawTime\":\"2022-12-03T12:00:00\"");
        assertThat(contentAsString).contains("\"userLotteryId\"");
//        resultForInputNumbers.andExpect(content().json("""
//                        {
//                        "drawTime":"2022-12-03T12:00:00",
//                        "userLotteryId":"e0f3440f-457e-462d-bc16-20a974f0b9d5",
//                        "error":false,
//                        "message":"all good"
//                        }
//                """.trim()));

        final ObjectMapper mapper = new ObjectMapper();
        NumberReceiverResultDto numberReceiverResultDto1 = mapper.readValue(contentAsString, NumberReceiverResultDto.class);
        String id = numberReceiverResultDto1.userLotteryId();

        // STEP 2 user want to know if won before draw date
        // given
        MockHttpServletRequestBuilder get = MockMvcRequestBuilders.get("/winners/" + id);
        // when
        ResultActions perform = mockMvc.perform(get
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON));
        // then




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
