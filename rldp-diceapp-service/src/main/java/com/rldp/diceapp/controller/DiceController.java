package com.rldp.diceapp.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rldp.diceapp.model.DiceRequest;
import com.rldp.diceapp.model.DiceResponse;
import com.rldp.diceapp.model.DiceResponseReport;
import com.rldp.diceapp.service.DiceService;

@RestController
@RequestMapping("dice")
public class DiceController {

	@Autowired
	private DiceService diceService;

	@GetMapping("roll")
	public ResponseEntity<DiceResponse> roll(
			@Valid DiceRequest request) {
		return new ResponseEntity<>(diceService.rollDice(request), HttpStatus.OK);
	}

	@GetMapping("report")
	public ResponseEntity<DiceResponseReport> get() {
		return new ResponseEntity<>(diceService.getResults(), HttpStatus.OK);
	}
}
