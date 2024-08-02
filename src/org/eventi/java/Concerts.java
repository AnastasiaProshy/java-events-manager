package org.eventi.java;

import java.time.LocalDate;
import java.time.LocalTime;

public class Concerts extends Event
{
	private LocalTime time;
	private float pricing;	
	
	Concerts (String title, LocalDate data, int totSeats, int bookedSeats, LocalTime time, float pricing)
	{
		super (title, data, totSeats, bookedSeats);
		this.time = time;
		this.pricing = pricing;
	}

}
