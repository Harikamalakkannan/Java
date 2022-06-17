package com.sportsDetails.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor  //generates a constructor with one parameter for each field in your class
@Table(name = "sports_details")
public class sportsDetails {
	@Id
	@Column(name = "sports_id")
    private int sportsId;
	private String Softball;
	private String Cricket;
	private String Volleyball;
	private String Basketball;
	private String Handball;
	private String Tennis;
	public int getSportsId() {
		return sportsId;
	}
	public void setSportsId(int sportsId) {
		this.sportsId = sportsId;
	}
	public String getSoftball() {
		return Softball;
	}
	public void setSoftball(String softball) {
		Softball = softball;
	}
	public String getCricket() {
		return Cricket;
	}
	public void setCricket(String cricket) {
		Cricket = cricket;
	}
	public String getVolleyball() {
		return Volleyball;
	}
	public void setVolleyball(String volleyball) {
		Volleyball = volleyball;
	}
	public String getBasketball() {
		return Basketball;
	}
	public void setBasketball(String basketball) {
		Basketball = basketball;
	}
	public String getHandball() {
		return Handball;
	}
	public void setHandball(String handball) {
		Handball = handball;
	}
	public String getTennis() {
		return Tennis;
	}
	public void setTennis(String tennis) {
		Tennis = tennis;
	}
	
	
}
