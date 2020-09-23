package com.people.villasise.service;

import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TotalPopulationServiceTest {

	@Autowired
	private TotalPopulationService totalPopulationService;
	
	@Test
	public void InsertPopulation() throws IOException {

		totalPopulationService.insertPopulation();
		
	}
}
