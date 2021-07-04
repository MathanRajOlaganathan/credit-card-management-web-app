package com.sapient.rest.domain.validator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 04/07/2021
 */
class LuhnValidatorTest {

    private ConstraintValidatorContext constraintValidatorContext;
    private LuhnValidator luhnValidator;


    @BeforeEach
    public void setUp(){
        constraintValidatorContext = mock(ConstraintValidatorContext.class);
        luhnValidator = new LuhnValidator();
    }

    @Test
    public void testLuhn10Algorithm() {
        String cardNumber = "4716435917330099";
        assertTrue( luhnValidator.isValid(cardNumber,constraintValidatorContext) );

        String inValidCardNumber = "3123123123213";
        assertFalse( luhnValidator.isValid(inValidCardNumber,constraintValidatorContext) );
    }

    @Override
    public void initialize(LuhnConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}