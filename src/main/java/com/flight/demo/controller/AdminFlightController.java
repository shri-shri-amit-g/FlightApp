package com.flight.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.flight.demo.entity.Flight;
import com.flight.demo.service.IFlightService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/flights")
public class AdminFlightController {

	@Autowired
	private IFlightService flightService;
	
	@PostMapping("/addFlight")
	public ResponseEntity<String> addFlight(@Valid @RequestBody Flight flight){
		return ResponseEntity.ok(flightService.addFlight(flight));
		
	}
	
	@GetMapping("/{flightId}")
	public ResponseEntity<Flight> getFlightByFlightId(@PathVariable Integer flightId){
		return ResponseEntity.ok(flightService.viewFlight(flightId));
	}
	
	@GetMapping("/allFlights")
	public ResponseEntity<List<Flight>> getAllFlights(){
		return ResponseEntity.ok(flightService.viewAllFlights());
	}
	
	@PutMapping("/update/{flightId}")
	public ResponseEntity<String> updateFlight(@PathVariable Integer flightId,@Valid @RequestBody Flight flight){
		return ResponseEntity.ok(flightService.updateFlight(flightId,flight));
	}
	
	@DeleteMapping("/deleteFlight/{flightId}")
	public ResponseEntity<String> deleteFlight(@PathVariable Integer flightId){
		return ResponseEntity.ok(flightService.deleteFlight(flightId));
	}
}
