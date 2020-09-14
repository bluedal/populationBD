package com.people.villasise.domain;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.people.villasise.repository.TotalPopulationRepository;

@SpringBootTest
@RunWith(SpringRunner.class)
public class TotalPopulationTest {

	@Autowired
	private TotalPopulationRepository totalPopulationRepository;
	
	@Test
	public void get() {
		List<TotalPopulation> to =  totalPopulationRepository.findAll();
	}
}
