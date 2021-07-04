package com.sapient.rest.repository;

import com.sapient.rest.domain.entity.CreditCard;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Mathan Raj O
 * @version 1.0
 * @since 03/07/2021
 */
@Repository
public interface CreditCardRepository extends JpaRepository<CreditCard, Long> {

}
