package com.people.villasise.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.Table;

import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Table(name="nia_total_population_dev")
@Entity
@Data
@IdClass(TotalPopulationPK.class)
public class TotalPopulation {

	@Id
	@Column(name="SREG", length=255)
	private String sreg;
	
	@Id
	@Column(name="STD_MON", length=6)
	private String stdMon;
	
	@Column(name="TOTAL_POP_CNT", length=10)
	private int totalPopCnt;
	
	@Column(name="HOUSEHOLD_CNT", length=10)
	private int houseHoldCnt;
	
	@Column(name="HOUSEHOLD_RATIO")
	private float houseHoldRatio;
	
	@Column(name="MALE_POP_CNT", length=10)
	private int malePopCnt;
	
	@Column(name="FEMALE_POP_CNT", length=10)
	private int femalePopCnt;
	
	@Column(name="GEN_RATIO")
	private float genRatio;
	
	@Builder
	public TotalPopulation(String sreg, 
						String stdMon, 
						int totalPopCnt, 
						int houseHoldCnt, 
						float houseHoldRatio, 
						int malePopCnt, 
						int femalePopCnt, 
						float genRatio) {
		
		this.sreg = sreg;
		this.stdMon = stdMon;
		this.totalPopCnt = totalPopCnt;
		this.houseHoldCnt = houseHoldCnt;
		this.houseHoldRatio = houseHoldRatio;
		this.malePopCnt = malePopCnt;
		this.femalePopCnt = femalePopCnt;
		this.genRatio = genRatio;
		
	}
}
