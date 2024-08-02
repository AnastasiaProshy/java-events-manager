package org.eventi.java;

//date management
import java.time.LocalDate;									 //date organizer
import java.time.LocalTime; 									//time organizer
import java.time.format.DateTimeFormatter; 		//date formatter

import java.util.Scanner;

public class Main 
{
	public static void main(String[] args) 
	{	
		Concerts userEvent = new Concerts (null, null, 0, 0, null, 0);		
		LocalDate dataEvent = null;
		LocalTime timeEvent = null;
		Scanner noteDown = new Scanner(System.in); //scanner assignment

		while(true) 
		{						
			System.out.println("\nwrite \"create\" if you want to add new event, \n"
					+ "write \"book\" if you want to book a ticket, \n"
					+ "write \"cancel\" if you want to cancel your booking  \n");			
			String userBook = noteDown.nextLine();		//scanner
			}				
		}		
	}
}
