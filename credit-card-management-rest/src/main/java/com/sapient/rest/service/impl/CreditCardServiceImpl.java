package com.sapient.rest.service.impl;

import com.sapient.rest.domain.dto.CreditCardRequest;
import com.sapient.rest.domain.entity.CreditCard;
import com.sapient.rest.domain.mapper.CreditCardMapper;
import com.sapient.rest.repository.CreditCardRepository;
import com.sapient.rest.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 03/06/2021
 */
@Service
@RequiredArgsConstructor
@Slf4j
public class CreditCardServiceImpl implements CreditCardService {

    private final CreditCardRepository creditCardRepository;

    private final CreditCardMapper creditCardMapper;

    @Override
    public CreditCard findById(Long Id) {
        return creditCardRepository.findById(Id).get();
    }

    @Override
    public List<CreditCard> findAll() {
        return creditCardRepository.findAll();
    }


    @Override
    public CreditCard addCreditCard(CreditCardRequest creditCardRequest) {
        return creditCardRepository.save(creditCardMapper.toCreditCard(creditCardRequest));
    }
}
