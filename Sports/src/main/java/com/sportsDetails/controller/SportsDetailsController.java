package com.sportsDetails.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sportsDetails.service.SportsDetailsService;

@RestController
	public class SportsDetailsController {
@Autowired
	private SportsDetailsService sportsDetailsService;
@GetMapping("/sportsDetails")
	public ResponseEntity<?> getAllsportsDetails() {
    	return ResponseEntity.ok(this.sportsDetailsService.getAllsportsDetails());
}
}
