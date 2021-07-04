package com.sapient.rest.domain.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 03/07/2021
 */
@Constraint(validatedBy = LuhnValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface LuhnConstraint {
    String message() default "Invalid Credit Card Number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
