package com.people.villasise.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.people.villasise.domain.TotalPopulation;
import com.people.villasise.domain.TotalPopulationPK;

@Repository
public interface TotalPopulationRepository  extends JpaRepository<TotalPopulation, TotalPopulationPK>{

	boolean existsByStdMon(String stdMon);
}
