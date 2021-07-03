package com.sapient.rest.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 03/06/2021
 */
@Entity
@Data
@RequiredArgsConstructor
@AllArgsConstructor
public class CreditCard {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    @Column(name = "ID")
    private Long id;

    @Column(name = "CARD_NUMBER")
    private Long cardNumber;

    @Column(name = "CARD_TYPE")
    private String cardType;

    @Column(name = "CARD_HOLDER_NAME")
    private String cardHolderName;

}
