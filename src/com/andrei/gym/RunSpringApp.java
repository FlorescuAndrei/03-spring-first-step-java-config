package com.andrei.gym;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.andrei.gym.coach.Coach;
import com.andrei.gym.coach.CricketCoach;
import com.andrei.gym.coach.TrackCoach;

//Spring Java configuration. Inversion of control . Dependency Injection.

public class RunSpringApp {

	public static void main(String[] args) {
		
		//load Spring config class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SportConfig.class);
		
		
	
		//BaseballCoach to illustrate working with @ComponentScan and Annotation
		Coach coach = context.getBean("baseballCoach", Coach.class); 
		System.out.println(coach.getDailyWorkout());
		System.out.println(coach.getDailyFortune());
				
	
		//@Bean instead of @ComponentScan
		CricketCoach cricketCoach = context.getBean("cricketCoach", CricketCoach.class); 
		
		System.out.println("\n" + cricketCoach.getDailyWorkout());
		
		System.out.println(cricketCoach.getDailyFortune());
		
		System.out.println(cricketCoach.getEmailAddress());
		
		System.out.println(cricketCoach.getLogo());
		
		
		
		
		TrackCoach theCoach=context.getBean("trackCoach", TrackCoach.class);
		System.out.println(theCoach.getDailyWorkout());
		
		TrackCoach alphaCoach=context.getBean("trackCoach", TrackCoach.class);
		
		//Bean scope. Check if they are the same (singleton vs prototype scope)
		boolean result = (theCoach == alphaCoach);
		System.out.println("\nTrack Coach: Scope - singleton vs prototype");
		System.out.println("Pointing to the same object " + result);
		System.out.println("Memory location for theCoach " + theCoach);
		System.out.println("Memory location for alphaCoach " + alphaCoach);
		
		
		//Bean life cycle : for prototype scope the destroy method is not call
		
		
		
		
		context.close();

	}

}
