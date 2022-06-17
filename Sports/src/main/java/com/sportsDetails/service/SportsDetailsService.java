package com.sportsDetails.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sportsDetails.model.sportsDetails;
import com.sportsDetails.reposirory.sportsDetailsRepository;

@Service
public class SportsDetailsService {
@Autowired
private List<sportsDetails> sportsDetailsRepo;
private sportsDetailsRepository repository;

	 public List<sportsDetails> getAllsportsDetails()
	    {
	        return this.sportsDetailsRepo;
	    }
	
	 public void SportsDetailsService(sportsDetailsRepository repository)
	    {
	        // this keyword refers to current instance
	        this.repository = repository;
	    }
}
