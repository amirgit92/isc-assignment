package ir.isc.assignment.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import ir.isc.assignment.model.CardType;
import ir.isc.assignment.model.RegisteringNewCardDTO;
import ir.isc.assignment.service.CardServiceImp;
import ir.isc.assignment.service.CustomerServiceImp;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Import;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.context.WebApplicationContext;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

@RunWith(SpringRunner.class)
@WebMvcTest(CardController.class)
@Import(CardController.class)
class CardControllerTest {

    @Autowired
    private MockMvc mvc;
    @Autowired
    private ObjectMapper objectMapper;

    @MockBean
    private CardServiceImp cardService;
    @MockBean
    CustomerServiceImp customerService;
    @MockBean
    ModelMapper modelMapper;
    @MockBean
    CommandLineRunner run;
    @Autowired
    WebApplicationContext webApplicationContext;

    @Test
    void getCardWithoutPayload() throws Exception {
        MvcResult result = mvc.perform(get("/api/card/get")).andReturn();

        assertEquals(400, result.getResponse().getStatus());
    }

    @Test
    void getCardWithCorrectNationalNumber() throws Exception {
        MvcResult result = mvc.perform(get("/api/card/get?cardNumber=1111111234567890")).andReturn();

        assertEquals(200, result.getResponse().getStatus());
    }

    @Test
    void createNewCardTest() throws Exception {
        RegisteringNewCardDTO newDto = new RegisteringNewCardDTO();
        newDto.setCardType(CardType.credit);
        newDto.setIssuerName("sepah");
        newDto.setOwnerNationalNumber("1450543197");

        MvcResult result = mvc.perform(post("/api/card/new").contentType(MediaType.APPLICATION_JSON)
                        .content(objectMapper.writeValueAsString(newDto))).andReturn();

                assertEquals(200, result.getResponse().getStatus());
    }



}