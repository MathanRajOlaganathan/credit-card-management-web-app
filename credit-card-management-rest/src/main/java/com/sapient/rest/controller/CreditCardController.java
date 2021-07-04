package com.sapient.rest.controller;

import com.sapient.rest.domain.dto.CreditCardRequest;
import com.sapient.rest.domain.entity.CreditCard;
import com.sapient.rest.service.CreditCardService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

import static com.sapient.rest.constants.ApplicationConstant.GET_BY_ID;
import static com.sapient.rest.constants.ApplicationConstant.ROOT_PATH;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 03/07/2021
 */
@RestController
@RequestMapping(ROOT_PATH)
@RequiredArgsConstructor
@Tag(name = "Credit Card Management Service REST endpoints")
@Slf4j
public class CreditCardController {

    private final CreditCardService creditCardService;


    @GetMapping
    @Operation(summary = "Find credit card", description = "Find all credit cards")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    public ResponseEntity<List<CreditCard>> findAllCreditCards() {
        log.info("Request to find all credit cards");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(creditCardService.findAll());
    }

    @GetMapping(GET_BY_ID)
    @Operation(summary = "Find credit card", description = "Find credit card by id")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "success"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    public ResponseEntity<CreditCard> findCreditCardById(@PathVariable Long id) {
        log.info("Request to find credit card by id");
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(creditCardService.findById(id));
    }


    @PostMapping
    @Operation(summary = "Add new credit card", description = "Add new credit card")
    @ApiResponses(value = {@ApiResponse(responseCode = "201", description = "Created"),
            @ApiResponse(responseCode = "400", description = "Bad Request"),
            @ApiResponse(responseCode = "500", description = "Internal Server Error")})
    public ResponseEntity<CreditCard> addCreditCard(@RequestBody @Valid CreditCardRequest creditCardRequest) {
        log.info("Request to add new credit card");
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(creditCardService.addCreditCard(creditCardRequest));
    }
}
