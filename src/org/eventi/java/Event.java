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
		
		public String toString() {
			return this.data + " - " + this.title;
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

		public void setBookedSeats(int book) 
		{						
			System.out.println("Book: " + book);
			if (book >= 0)
			{
				if (((book + this.bookedSeats) < this.totSeats) 
						&& (!data.isBefore(LocalDate.now())))
				{
					this.bookedSeats = this.bookedSeats + book;
					System.out.println("Your request has been successfully fulfilled");				
				}
				else
				{
					System.out.println("There's no ticket available");
				}
			}		
		}		
}
