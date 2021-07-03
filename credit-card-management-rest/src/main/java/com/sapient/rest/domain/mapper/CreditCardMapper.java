package com.sapient.rest.domain.mapper;

import com.sapient.rest.domain.dto.CreditCardRequest;
import com.sapient.rest.domain.entity.CreditCard;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 03/06/2021
 */
public interface CreditCardMapper {

    CreditCard toCreditCard(CreditCardRequest creditCardRequest);
}
