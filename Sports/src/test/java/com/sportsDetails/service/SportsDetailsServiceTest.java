package com.sportsDetails.service;

import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.sportsDetails.reposirory.sportsDetailsRepository;

@ExtendWith(MockitoExtension.class)
public class SportsDetailsServiceTest {
	@Mock 
	private sportsDetailsRepository sportsDetailsRepository;
	 
    private SportsDetailsService SportsDetailsService;
 
    @BeforeEach void setUp()
    {
        this.SportsDetailsService
            = new SportsDetailsService();
    }
 
    @Test void getAllPerson()
    {
    	SportsDetailsService.getAllsportsDetails();
        verify(sportsDetailsRepository).findAll();
    }
}
