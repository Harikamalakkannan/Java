package com.sportsDetails.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sportsDetails.model.sportsDetails;
import com.sportsDetails.reposirory.sportsDetailsRepository;

@SpringBootTest
public class SportsDetailsRepository {
	@Autowired
    private sportsDetailsRepository sportsDetailsRepository;
 
    @Test
    void isSportsDetailsExitsById() {
    	sportsDetails sportsDetails = new sportsDetails();
    	SportsDetailsRepository.save(sportsDetailsRepository);
        Boolean actualResult = sportsDetailsRepository.issportsDetailsExitsById(1001);
        assertThat(actualResult).isTrue();
    }

	private static void save(com.sportsDetails.reposirory.sportsDetailsRepository sportsDetailsRepository2) {
		// TODO Auto-generated method stub
		
	}
}
