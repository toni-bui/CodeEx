package com.example.demo.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
public class BreedControllerTest {

	@Autowired
	MockMvc mvc;

	// private M
	@Test
	public void getList_Status200() throws Exception {
		mvc.perform(get("/list/all")
			.contentType(MediaType.APPLICATION_JSON))
			.andExpect(status().isOk());
	}

}
