package com.sapient.rest.domain.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 03/06/2021
 */
@Getter
@Setter
@NoArgsConstructor
public class CreditCardRequest {

    private Long cardNumber;

    private String cardType;

    private String cardHolderName;
}
