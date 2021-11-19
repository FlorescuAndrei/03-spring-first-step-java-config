package com.andrei.gym.coach;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.stereotype.Component;

import com.andrei.gym.fortune.FortuneService;


public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	
	public TrackCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		
		return "Run a hard 5k";
	}

	@Override
	public String getDailyFortune() {
		
		return "Just Do It " + fortuneService.getFortune();
	}
	
	//bean life cycle. Preferable void method. Method can not accept any argument
	
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println("TrackCoach: inside doMyStartupStuff");
	}
	
	@PreDestroy
	public void doMyCleanupStuff() {
		System.out.println("TrackCoach: inside doMyCleanupStuff");
	}

}
