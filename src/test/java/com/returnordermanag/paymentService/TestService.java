package com.returnordermanag.paymentService;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.returnordermanag.paymentService.dao.CardRepo;
import com.returnordermanag.paymentService.model.CreditCard;
import com.returnordermanag.paymentService.service.CardService;

@ExtendWith(MockitoExtension.class)
class TestService {

	/*
	 * @BeforeAll public void init() { MockitoAnnotations.initMocks(this); }
	 */
	@Mock
	CardRepo repo;
	
	@Mock
	CreditCard card;
	
	@InjectMocks
	CardService service;
	
	@Test
	void testProcessPayment() {
		
		card=new CreditCard(4876974648769746L,4000);
		when(repo.findByCardNumber(4876974648769746L)).thenReturn(card);
		when(repo.save(any(CreditCard.class))).thenReturn(card);
		
		
		assertEquals(2500.0,service.processPayment(4876974648769746L, 1500));
		assertEquals(-1,service.processPayment(4876974648769746L, 6000));
		
	}
}
