package com.rldp.diceapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("dice")
public class DiceController {

	@GetMapping("roll")
	public ResponseEntity<String> roll()
	{
		return new ResponseEntity<>("Roll", HttpStatus.OK);
	}
}
