package com.andrei.gym;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.Scope;

import com.andrei.gym.coach.Coach;
import com.andrei.gym.coach.CricketCoach;
import com.andrei.gym.coach.TrackCoach;
import com.andrei.gym.fortune.FortuneService;
import com.andrei.gym.fortune.HappyFortuneService;
import com.andrei.gym.fortune.RandomFortuneService;

@Configuration
@ComponentScan("com.andrei.gym")		//optional if we do not want to use @Bean. But  must use @Component and the others annotation  in entity class
@PropertySource("classpath:sport.properties")
public class SportConfig {
	
	@Bean
	public FortuneService happyFortune() {
		return new HappyFortuneService();
	}
	
	@Bean 
	public FortuneService randomFortune() {
		return new RandomFortuneService();
	}
	
	
	@Bean
	@Scope("singleton") 
	public Coach trackCoach() {
		TrackCoach trackCoach = new TrackCoach(randomFortune());
		return trackCoach;
	}
	
	@Bean
	public Coach cricketCoach() {
		CricketCoach cricketCoach = new CricketCoach();
		cricketCoach.setFortuneService(randomFortune());
		
		return cricketCoach;
	}

}
