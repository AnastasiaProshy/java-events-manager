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

		public void setData(LocalDate data)  
		{			
			this.data = data;
		}
	
		public String getTitle() {
			return title;
		}
		
		public LocalDate getData() {
			return data;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public int getTotSeats() {
			return totSeats;
		}

		public void setTotSeats(int totSeats) {
			this.totSeats = totSeats;
		}

		public int getBookedSeats() {
			return bookedSeats;
		}
}
