package com.sportsDetails.reposirory;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.sportsDetails.model.sportsDetails;

public interface sportsDetailsRepository extends JpaRepository<sportsDetails,Integer>{
	@Query(
	        "SELECT CASE WHEN COUNT(s) > 0 THEN TRUE ELSE FALSE END FROM sportsDetails s WHERE s.sportsDetailsId = ?1")
	    Boolean
	    issportsDetailsExitsById(Integer id);
	}

