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
			switch(userBook) 
			{
				//event creator
				case "create":						
					System.out.println("Type down new event name: ");
					String eventTitle = noteDown.nextLine();											    
					int i = 0;
					while (i != 1)
					{
						System.out.println("Type down new event data (dd/mm/yyyy) : ");
						String dataEventString = noteDown.nextLine();	
						try
						{							
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");  //	defines the date format to use
						    dataEvent = LocalDate.parse(dataEventString, formatter);								  //	compare and transform string to date format using the above DateTimeFormatter
						   
						    if (!dataEvent.isBefore(LocalDate.now()))
							{
						    	i = 1;
							}
						    else
						    {
						    	i  = 0;
						    	System.out.println("The date you have chosen has already passed, insert a future date,");
						    }						    
						}
						catch (Exception e)																							   		  //generic exception management	
						{  		   
							System.out.println("Something went wrong, please retype your date of birth,");
						}	
					}
					
					System.out.println("Insert available seats: ");
					Integer totSeats = Integer.parseInt(noteDown.nextLine());		
					
					//concert class price and time
					System.out.println("Price in €: ");
					Float price = Float.valueOf(noteDown.nextLine());		
					
					break;
			}				
		}		
	}
}
