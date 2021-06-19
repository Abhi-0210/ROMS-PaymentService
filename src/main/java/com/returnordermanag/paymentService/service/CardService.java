package com.returnordermanag.paymentService.service;

import java.util.NoSuchElementException;

import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.returnordermanag.paymentService.dao.CardRepo;
import com.returnordermanag.paymentService.exception.CardNotFoundException;
import com.returnordermanag.paymentService.model.CreditCard;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class CardService {
	
	//static Logger logger = LoggerFactory.getLogger(CardService.class);

	@Autowired
	CardRepo cardRepo;
	
	@Transactional
	public double processPayment(long cardNumber,double charge) throws NoSuchElementException, CardNotFoundException {
	
		log.info("Processing payment");
		
		CreditCard card=cardRepo.findByCardNumber(cardNumber);
	
		double balance= card.getCardLimit()-charge;
		if(balance>0) {
			card.setCardLimit(balance);
			cardRepo.save(card);
			return balance;
		}
		else {
			return -1;
		}
	}
}
