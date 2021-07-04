package com.sapient.rest.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.math.BigDecimal;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 03/07/2021
 */
@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long cardNumber;

    private String cardHolderName;

    private BigDecimal cardLimit;

    private BigDecimal balance = BigDecimal.valueOf(0);

    public CreditCard(Long cardNumber, String cardHolderName, BigDecimal limit, BigDecimal balance) {
        this.cardNumber = cardNumber;
        this.cardHolderName = cardHolderName;
        this.cardLimit = limit;
        this.balance = balance;
    }
}
