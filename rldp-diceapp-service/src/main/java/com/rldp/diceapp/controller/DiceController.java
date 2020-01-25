package com.rldp.diceapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rldp.diceapp.model.DiceResponse;
import com.rldp.diceapp.service.DiceService;

@RestController
@RequestMapping("dice")
public class DiceController {

	@Autowired
	private DiceService diceService;

	@GetMapping("roll")
	public ResponseEntity<DiceResponse> roll() {
		return new ResponseEntity<>(diceService.rollDice(), HttpStatus.OK);
	}
}
