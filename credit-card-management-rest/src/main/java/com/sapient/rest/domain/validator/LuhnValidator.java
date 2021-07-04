package com.sapient.rest.domain.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 03/07/2021
 */
public class LuhnValidator implements ConstraintValidator<LuhnConstraint,String> {


    @Override
    public void initialize(LuhnConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String creditCardNo, ConstraintValidatorContext constraintValidatorContext) {
        int[] ints = new int[creditCardNo.length()];

        for (int i = 0; i < creditCardNo.length(); i++) {
            ints[i] = Integer.parseInt(creditCardNo.substring(i, i + 1));
        }
        for (int i = ints.length - 2; i >= 0; i = i - 2) {
            int j = ints[i];
            j = j * 2;
            if (j > 9) {
                j = j % 10 + 1;
            }
            ints[i] = j;
        }
        int sum = 0;
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
        }
        return  (sum % 10 == 0) ;
    }
}
