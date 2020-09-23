package com.people.villasise.service;

import java.io.IOException;
import java.io.LineNumberReader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.people.villasise.domain.TotalPopulation;
import com.people.villasise.repository.TotalPopulationRepository;

@Service
public class TotalPopulationService {
	
	@Autowired
	private TotalPopulationRepository totalPopulationRepository;
	
	public void insertPopulation() throws IOException {

		List<TotalPopulation> totalPopulationList = new ArrayList<>();		
		
		Path path = Paths.get("/Users/hwang-il-yeong/Downloads/population/");
		Optional<Path> getPathFile =  Files.walk(path)
	 				.filter(elem -> elem.getFileName().toString().matches("totalPopulation_\\d{6}.txt"))
	 				.findFirst();
		
		if(getPathFile.orElse(null) != null) {
		
			try(LineNumberReader reader = new LineNumberReader(Files.newBufferedReader(getPathFile.get(),StandardCharsets.ISO_8859_1))) {
				
				String line = null;
				while ((line = reader.readLine()) != null) {
					if(reader.getLineNumber() != 1) {
						
						int startIndex = line.indexOf("(");
						String[] populationArr = line.substring(startIndex, line.length()).split("	");
		
						Pattern pattern = Pattern.compile("\\d{6}");
						Matcher matcher = pattern.matcher(getPathFile.get().getFileName().toString());
						
						TotalPopulation total = TotalPopulation.builder()
								.sreg(populationArr[0].substring(1,6))
								.stdMon(matcher.find() ? matcher.group() : "000000")
								.totalPopCnt(Integer.parseInt(populationArr[1]))
								.houseHoldCnt(Integer.parseInt(populationArr[2]))
								.houseHoldRatio(Float.parseFloat(populationArr[3]))
								.malePopCnt(Integer.parseInt(populationArr[4]))
								.femalePopCnt(Integer.parseInt(populationArr[5]))
								.genRatio(Float.parseFloat(populationArr[6]))
								.build();
						
						totalPopulationList.add(total);
						
					}
				
		         }
				
				totalPopulationRepository.saveAll(totalPopulationList);
				
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		} else {
			System.out.println("해당 파일이 경로에 없습니다.");

		}

	}
}