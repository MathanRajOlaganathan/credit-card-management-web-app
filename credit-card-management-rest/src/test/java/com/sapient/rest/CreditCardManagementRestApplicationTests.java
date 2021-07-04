package com.sapient.rest;

import com.sapient.rest.repository.CreditCardRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static com.sapient.rest.constants.ApplicationConstant.ROOT_PATH;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 04/07/2021
 */

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CreditCardManagementRestApplicationTests {

    @LocalServerPort
    private int port;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CreditCardRepository creditCardRepository;


    @Test
    @DisplayName("Testing add credit card")
    void testAddCreditCard() throws Exception {
        String request = "{\"cardNumber\":\"346050620516508\",\"cardLimit\":\"10000\",\"cardHolderName\":\"Test\"}";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(ROOT_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andReturn();
        assertEquals(201, mvcResult.getResponse().getStatus(), "The expected response status is different from the actual");
    }


    @Test
    @DisplayName("Testing Bad Request")
    void whenEmptyValue_thenReturns400() throws Exception {
        String request = "{\"cardNumber\":\"\",\"cardLimit\":\"\",\"cardHolderName\":\"\"}";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(ROOT_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andReturn();
        assertEquals(400, mvcResult.getResponse().getStatus());
        assertTrue(mvcResult.getResponse().getContentAsString().contains("cardNumber cannot be empty\""));
    }

    @Test
    @DisplayName("Testing Bad Request - Not a valid Credit Card Number based on Luhn")
    void whenCardNumberIsNotValidByLuhn_thenReturns400() throws Exception {
        String request = "{\"cardNumber\":\"3460506208\",\"cardLimit\":\"10000\",\"cardHolderName\":\"Test\"}";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(ROOT_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andReturn();
        assertEquals(400, mvcResult.getResponse().getStatus());
        assertTrue(mvcResult.getResponse().getContentAsString().contains("Not a valid credit card number"));
    }

    @Test
    @DisplayName("Testing Bad Request - cardNumber cannot be more than 19 characters")
    void whenCardNumber_LengthMoreThan19Chars_thenReturns400() throws Exception {
        String request = "{\"cardNumber\":\"346050620321312321321328\",\"cardLimit\":\"10000\",\"cardHolderName\":\"Test\"}";
        MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders.post(ROOT_PATH)
                .contentType(MediaType.APPLICATION_JSON)
                .content(request))
                .andReturn();

        assertEquals(400, mvcResult.getResponse().getStatus());
        assertTrue(mvcResult.getResponse().getContentAsString().contains("cardNumber cannot be more than 19 characters"));
    }


    @Test
    @DisplayName("Testing Not Found 404")
    void whenBigGameRuleNull_thenReturns404() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get(ROOT_PATH + "/9"))
                .andExpect(status().isNotFound());
    }

}
