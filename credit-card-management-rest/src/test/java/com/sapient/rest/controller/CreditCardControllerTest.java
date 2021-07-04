package com.sapient.rest.controller;

import com.sapient.rest.domain.dto.CreditCardRequest;
import com.sapient.rest.domain.entity.CreditCard;
import com.sapient.rest.exception.NotFoundException;
import com.sapient.rest.service.CreditCardService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.math.BigDecimal;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 04/07/2021
 */
@ExtendWith(MockitoExtension.class)
class CreditCardControllerTest {

    @InjectMocks
    CreditCardController creditCardController;

    @Mock
    CreditCardService creditCardService;

    private static CreditCardRequest creditCardRequest;

    private static List<CreditCard> creditCardList;

    private static CreditCard creditCard;

    @BeforeAll
    public static void setup() {
        creditCardRequest = new CreditCardRequest("5018850020615925", "Rock", BigDecimal.valueOf(1000));
        creditCard = new CreditCard(4L, 5018850020615925L, "Rock", BigDecimal.valueOf(1000), BigDecimal.valueOf(0));
        creditCardList = List.of(
                new CreditCard(1L, 4539818394342882L, "Alex", BigDecimal.valueOf(1000), BigDecimal.valueOf(5000)),
                new CreditCard(2L, 2221006488214442L, "Rohan", BigDecimal.valueOf(2000), BigDecimal.valueOf(6000)),
                new CreditCard(3L, 341067730624803L, "Holly", BigDecimal.valueOf(4500), BigDecimal.valueOf(7000)));
    }

    @Test
    @DisplayName("Testing the positive case of findAllCreditCards")
    void findAllCreditCards() {
        when(creditCardService.findAll()).thenReturn(creditCardList);
        ResponseEntity<List<CreditCard>> actualResponse = creditCardController.findAllCreditCards();
        assertEquals(200, actualResponse.getStatusCodeValue(), "The expected response status is different from the actual");
        assertEquals(creditCardList, actualResponse.getBody(), "The expected and actual response are not same");
    }

    @Test
    @DisplayName("Testing the positive case of findCreditCardsById")
    void findCreditCardsById() {
        when(creditCardService.findById(1L)).thenReturn(creditCardList.get(1));
        ResponseEntity<CreditCard> actualResponse = creditCardController.findCreditCardById(1L);
        assertEquals(200, actualResponse.getStatusCodeValue(), "The expected response status is different from the actual");
        assertEquals(creditCardList.get(1), actualResponse.getBody(), "The expected and actual response are not same");
    }


    @Test
    @DisplayName("Testing the negative case of findCreditCardsById")
    void findCreditCardsByIdThrowException() {
        when(creditCardService.findById(5L)).thenThrow(new NotFoundException("Credit Card not found"));
        assertThrows(NotFoundException.class, () -> {
            creditCardController.findCreditCardById(5L);
        });
    }

    @Test
    @DisplayName("Testing the positive case of addCreditCard")
    void addCreditCard() {
        when(creditCardService.addCreditCard(creditCardRequest)).thenReturn(creditCard);
        ResponseEntity<CreditCard> actualResponse = creditCardController.addCreditCard(creditCardRequest);
        assertEquals(201, actualResponse.getStatusCodeValue(), "The expected response status is different from the actual");
        assertEquals(creditCard, actualResponse.getBody(), "The expected and actual response are not same");
    }


}