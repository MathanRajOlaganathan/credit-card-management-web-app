package com.sapient.rest.service;

import com.sapient.rest.domain.dto.CreditCardRequest;
import com.sapient.rest.domain.entity.CreditCard;

import java.util.List;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 03/07/2021
 */
public interface CreditCardService {

    List<CreditCard> findAll();

    CreditCard findById(Long id);

    CreditCard addCreditCard(CreditCardRequest creditCardRequest);


}
