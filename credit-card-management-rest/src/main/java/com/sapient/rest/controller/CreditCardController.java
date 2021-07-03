package com.sapient.rest.controller;

import com.sapient.rest.domain.dto.CreditCardRequest;
import com.sapient.rest.domain.entity.CreditCard;
import com.sapient.rest.service.CreditCardService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import static com.sapient.rest.constants.ApplicationConstant.GET_BY_ID;
import static com.sapient.rest.constants.ApplicationConstant.ROOT_PATH;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 03/06/2021
 */
@RestController
@RequestMapping(ROOT_PATH)
@RequiredArgsConstructor
@Slf4j
public class CreditCardController {

    private final CreditCardService creditCardService;


    @GetMapping
    public ResponseEntity<?> findAllCreditCards() {
        log.info("Request to find all credit cards");
        return new ResponseEntity<>(creditCardService.findAll(), HttpStatus.OK);
    }

    @GetMapping(GET_BY_ID)
    public ResponseEntity<?> getCreditCardsById(@PathVariable Long id) {
        log.info("Request to find credit card by id");
        return new ResponseEntity<>(creditCardService.findById(id), HttpStatus.OK);
    }


    @PostMapping
    public ResponseEntity<CreditCard> addCreditCard(@RequestBody @Valid CreditCardRequest creditCardRequest) {
        log.info("Request to add new credit card");
        CreditCard creditCard = creditCardService.addCreditCard(creditCardRequest);
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(creditCard);
    }
}
