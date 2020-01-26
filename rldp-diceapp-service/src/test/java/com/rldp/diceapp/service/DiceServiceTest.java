package com.rldp.diceapp.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mongodb.morphia.query.Query;

import com.rldp.diceapp.model.DiceRequest;
import com.rldp.diceapp.model.DiceResponse;
import com.rldp.diceapp.model.DiceResponseReport;
import com.rldp.diceapp.mongodb.repository.DiceResponseRepository;

public class DiceServiceTest {
	
	private DiceResponseRepository repository;
	private DiceService diceService;
	
	@BeforeEach
	public void init() {
		repository = mock(DiceResponseRepository.class);
		diceService = new DiceService(repository);
	}
	
	@Test
	void shouldRollDiceProperly() {
		final DiceRequest request = new DiceRequest();
		request.setPieces(3);
		request.setSides(6);
		request.setRolls(100);
		final DiceResponse diceResponse = diceService.rollDice(request);
		assertEquals(100, diceResponse.getDiceRollList().size());
		final List<Integer> results = diceResponse.getDiceRollList().get(0).getResults();
		assertEquals(3, results.size());
		results.forEach(num -> {
			assertTrue(num >= 1 && num <= 6);
		});
	}
	
	@Test
	public void shouldReturnTwoGroups() {
		
		final Query<DiceResponse> query = mock(Query.class);
		when(repository.createQuery()).thenReturn(query);
		final List<DiceResponse> list = new ArrayList<>();
		
		final DiceRequest request1 = new DiceRequest();
		request1.setPieces(2);
		request1.setSides(5);
		final DiceResponse response1 = new DiceResponse(request1);
		list.add(response1);
		
		final DiceRequest request2 = new DiceRequest();
		request2.setPieces(3);
		request2.setSides(5);
		final DiceResponse response2 = new DiceResponse(request2);
		list.add(response2);
		
		when(query.asList()).thenReturn(list);
		final DiceResponseReport results = diceService.getResults();
		assertEquals(2, results.getGroupList().size());
	}
	
	@Test
	public void shouldReturnTwoGroupsWithMultipleDiceResponses() {
		
		final Query<DiceResponse> query = mock(Query.class);
		when(repository.createQuery()).thenReturn(query);
		final List<DiceResponse> list = new ArrayList<>();
		
		final DiceRequest request1 = new DiceRequest();
		request1.setPieces(2);
		request1.setSides(5);
		final DiceResponse response1 = new DiceResponse(request1);
		list.add(response1);
		
		final DiceRequest request2 = new DiceRequest();
		request2.setPieces(2);
		request2.setSides(5);
		final DiceResponse response2 = new DiceResponse(request2);
		list.add(response2);
		
		final DiceRequest request3 = new DiceRequest();
		request3.setPieces(3);
		request3.setSides(5);
		final DiceResponse response3 = new DiceResponse(request3);
		list.add(response3);
		
		final DiceRequest request4 = new DiceRequest();
		request4.setPieces(3);
		request4.setSides(5);
		final DiceResponse response4 = new DiceResponse(request4);
		list.add(response4);
		
		final DiceRequest request5 = new DiceRequest();
		request5.setPieces(3);
		request5.setSides(5);
		final DiceResponse response5 = new DiceResponse(request5);
		list.add(response5);
		
		final DiceRequest request6 = new DiceRequest();
		request6.setPieces(3);
		request6.setSides(5);
		final DiceResponse response6 = new DiceResponse(request6);
		list.add(response6);
		
		when(query.asList()).thenReturn(list);
		final DiceResponseReport results = diceService.getResults();
		assertEquals(2, results.getGroupList().size());
	}
}
