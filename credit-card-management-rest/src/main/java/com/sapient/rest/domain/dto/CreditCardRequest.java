package com.sapient.rest.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.CreditCardNumber;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;
import java.math.BigDecimal;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 03/07/2021
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreditCardRequest {

    @NotBlank(message = "cardNumber " + "{validation.credit.notEmpty}")
    @Pattern(regexp = "^[0-9]*", message = "cardNumber " + "{validation.credit.numeric}")
    @Length(max = 19, message = "cardNumber " + "{validation.credit.size}")
    @CreditCardNumber(message = "{validation.credit.inValid}")
    private String cardNumber;

    @NotBlank(message = "cardHolderName " + "{validation.credit.notEmpty}")
    private String cardHolderName;

    @NotNull(message = "limit " + "{validation.credit.notEmpty}")
    @Positive
    private BigDecimal cardLimit;
}
