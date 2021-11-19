package com.andrei.gym.coach;

import org.springframework.beans.factory.annotation.Value;

import com.andrei.gym.fortune.FortuneService;

public class CricketCoach implements Coach {
	
	private FortuneService fortuneService;
	
	@Value("cricketteam@email.java")
	private String emailAddress;
	
	@Value("${foo.logo}")	
	private String logo;
	

	public String getLogo() {
		return logo;
	}

	public void setLogo(String logo) {
		this.logo = logo;
	}

	
	
	
	public CricketCoach() {
		System.out.println("CricketCoach: inside no-arg constructor");
	}
	
	
	public void setFortuneService(FortuneService fortuneService) {
		System.out.println("CricketCoach: inside method: setter method - setFortuneService");
		this.fortuneService = fortuneService;
	}



	public void setEmailAddress(String emailAddress) {
		System.out.println("CricketCoach: inside method: setter method - setEmailAdress");
		this.emailAddress = emailAddress;
	}

	
	public String getEmailAddress() {
		return emailAddress;
	}

	
	@Override
	public String getDailyWorkout() {
		
		return "Practice fast bowling for 15 minutes";
	}

	@Override
	public String getDailyFortune() {
		
		return "Cricket fortune: " + fortuneService.getFortune();
	}
	
	

}
