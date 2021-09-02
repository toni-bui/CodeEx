package com.example.demo.controllers;

import java.util.Map;
import java.util.List;

import com.example.demo.payload.DTOResponse;
import com.example.demo.services.BreedService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BreedController {

	@Autowired
	BreedService service;


	@GetMapping("/list/all")
	public DTOResponse<Map<String, List<String>>> getList() {
		DTOResponse<Map<String, List<String>>> response = new DTOResponse<>();
		response.setStatus("success");
		response.setMessage(service.getData());
		return response;
	}

}
