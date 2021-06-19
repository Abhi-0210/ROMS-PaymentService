package com.returnordermanag.paymentService.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.returnordermanag.paymentService.exception.CardNotFoundException;
import com.returnordermanag.paymentService.model.CreditCard;

@Repository
public interface CardRepo extends JpaRepository<CreditCard, String>{

	CreditCard findByCardNumber(long cardNumber)throws CardNotFoundException;

}
