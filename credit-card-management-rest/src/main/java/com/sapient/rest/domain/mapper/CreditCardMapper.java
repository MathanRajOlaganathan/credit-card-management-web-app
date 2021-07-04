package com.sapient.rest.domain.mapper;

import com.sapient.rest.domain.dto.CreditCardRequest;
import com.sapient.rest.domain.entity.CreditCard;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 03/07/2021
 */
@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface CreditCardMapper {

    CreditCard toCreditCard(CreditCardRequest creditCardRequest);
}
