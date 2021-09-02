package com.example.demo.services.impl;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.example.demo.services.BreedService;
import com.fasterxml.jackson.databind.ObjectMapper;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BreedServiceImp implements BreedService {

	@SuppressWarnings("unchecked")
	public Map<String, List<String>> getData() throws Exception {
		RestTemplate r = new RestTemplate();
		final String url = "https://raw.githubusercontent.com/mlenze/CodingExcercise-Java/main/apidata.json";
		ResponseEntity<String> res = r.getForEntity(url, String.class);
		ObjectMapper mapper = new ObjectMapper();
		Map<String, List<String>> m = mapper.readValue(res.getBody(), HashMap.class);

		m = m.entrySet().stream()
			.sorted(Map.Entry.comparingByKey())
			.collect(
				Collectors.toMap(
					Map.Entry::getKey,
					Map.Entry::getValue,
					(oldValue, newValue) -> oldValue, LinkedHashMap::new));
		m.forEach((key ,value) ->
			Collections.sort(value)
		);
		return m;
	}

}
