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

	@Override
	public String toString() 
	{
		return "Concerto: " + this.data + " - " + this.time + " - " + this.title + " - " + String.format("%.2f€",pricing);
	}	
	
	public LocalTime getTime() 
	{
		return time;
	}

	public void setTime(LocalTime time) 
	{
		this.time = time;
	}

	public float getPricing() 
	{
		return pricing;
	}

	public void setPricing(float pricing) 
	{
		this.pricing = pricing;
	}	
}
