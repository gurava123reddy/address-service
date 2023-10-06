package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Address;
import com.example.demo.repository.AddressRepository;

@RestController
@RequestMapping("/address-service")
public class AddressController {

	@Autowired
	private AddressRepository addressRepository;
	
	@PostMapping
	public ResponseEntity<String> saveAddress(@RequestBody Address address){
		addressRepository.save(address);
		return new ResponseEntity<>("Address saved successfully", HttpStatus.CREATED);
	}
	
	@GetMapping
	public ResponseEntity<List<Address>> getAddress(){
		List<Address> addresses = addressRepository.findAll();
		return new ResponseEntity<>(addresses, HttpStatus.CREATED);
	}
	
	
}
