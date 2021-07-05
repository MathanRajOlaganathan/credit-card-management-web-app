package com.sapient.rest.service.impl;

import com.sapient.rest.domain.dto.CreditCardRequest;
import com.sapient.rest.domain.entity.CreditCard;
import com.sapient.rest.domain.mapper.CreditCardMapper;
import com.sapient.rest.domain.mapper.CreditCardMapperImpl;
import com.sapient.rest.exception.NotFoundException;
import com.sapient.rest.repository.CreditCardRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import javax.persistence.EntityManager;
import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 04/07/2021
 */
@ExtendWith(MockitoExtension.class)
class CreditCardServiceImplTest {

    private static CreditCardRequest creditCardRequest;
    private static List<CreditCard> creditCardList;
    private static CreditCard creditCard;
    @InjectMocks
    CreditCardServiceImpl creditCardService;
    @Mock
    private CreditCardRepository creditCardRepository;
    @Mock
    private EntityManager entityManager;
    @Spy
    private CreditCardMapper creditCardMapper = Mappers.getMapper(CreditCardMapper.class);

    @BeforeAll
    public static void setUp() {
        CreditCardMapper creditCardMapper = new CreditCardMapperImpl();
        creditCardRequest = new CreditCardRequest("5018850020615925", "Rock", BigDecimal.valueOf(1000));
        creditCard = new CreditCard(null, 5018850020615925L, "Rock", BigDecimal.valueOf(1000), BigDecimal.valueOf(0));
        creditCardList = List.of(
                new CreditCard(1L, 4539818394342882L, "Alex", BigDecimal.valueOf(1000), BigDecimal.valueOf(5000)),
                new CreditCard(2L, 2221006488214442L, "Rohan", BigDecimal.valueOf(2000), BigDecimal.valueOf(6000)),
                new CreditCard(3L, 341067730624803L, "Holly", BigDecimal.valueOf(4500), BigDecimal.valueOf(7000)));

    }

    @Test
    @DisplayName("Testing the positive case of findCreditCardsById")
    void findById() {
        lenient().when(creditCardRepository.findById(1L)).thenReturn(Optional.ofNullable(creditCardList.get(1)));
        CreditCard actualResponse = creditCardService.findById(1L);
        assertEquals(creditCardList.get(1), actualResponse, "The expected and actual response are not same");

    }

    @Test
    @DisplayName("Testing the negative case of findCreditCardsById")
    void findByIdThrowException() {
        when(creditCardRepository.findById(5L)).thenThrow(new NotFoundException("Credit Card not found"));
        assertThrows(NotFoundException.class, () -> {
            creditCardService.findById(5L);
        });
    }

    @Test
    @DisplayName("Testing the positive case of findAll")
    void findAll() {
        when(creditCardRepository.findAll()).thenReturn(creditCardList);
        List<CreditCard> actualResponse = creditCardService.findAll();
        assertEquals(creditCardList, actualResponse, "The expected and actual response are not same");

    }

    @Test
    @DisplayName("Testing the positive case of addCreditCard")
    void addCreditCard() {
        lenient().when(creditCardRepository.save(creditCard)).thenReturn(creditCard);
        CreditCard actualResponse = creditCardService.addCreditCard(creditCardRequest);
        assertEquals(creditCard, actualResponse, "The expected and actual response are not same");
    }
}