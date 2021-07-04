package com.sapient.rest.config;

import com.sapient.rest.domain.entity.CreditCard;
import com.sapient.rest.repository.CreditCardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 04/07/2021
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class DataInitializer implements CommandLineRunner {

    private final CreditCardRepository creditCardRepository;

    @Override
    public void run(String... args) throws Exception {
        log.info("Adding credit cards");
        creditCardRepository.saveAll(List.of(
                new CreditCard(4539818394342882L, "Alex", BigDecimal.valueOf(1000), BigDecimal.valueOf(5000)),
                new CreditCard(2221006488214442L, "Rohan", BigDecimal.valueOf(2000), BigDecimal.valueOf(6000)),
                new CreditCard(341067730624803L, "Holly", BigDecimal.valueOf(4500), BigDecimal.valueOf(7000))));

    }
}
