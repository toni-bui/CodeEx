package com.example.demo.services.impl;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import com.example.demo.services.BreedService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.RestTemplate;

@Service
public class BreedServiceImp implements BreedService {

	@SuppressWarnings("unchecked")
	public Map<String, List<String>> getData() {
		RestTemplate r = new RestTemplate();
		final String url = "https://raw.githubusercontent.com/mlenze/CodingExcercise-Java/main/apidata.json";
		ResponseEntity<String> res = r.getForEntity(url, String.class);
		ObjectMapper mapper = new ObjectMapper();
		try {
			Map<String, List<String>> m = mapper.readValue(res.getBody(), LinkedHashMap.class);
			return m;
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
		return null;
	}

}
