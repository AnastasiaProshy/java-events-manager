package org.eventi.java;

//date management
import java.time.LocalDate; //date organizer

public class Event 
{	
		protected String title;
		protected LocalDate data; 
		protected int totSeats;
		private int bookedSeats;		

		public Event (String title, LocalDate data, int totSeats, int bookedSeats) 
		{
			this.title = title;
			this.data = data;
			this.totSeats = totSeats;
			this.bookedSeats = 0;	
		}
}
