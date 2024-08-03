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
		ProgramEvents programEvent = new ProgramEvents (null, null);
		Concerts userEvent = new Concerts (null, null, 0, 0, null, 0);		
		LocalDate dataEvent = null;
		LocalTime timeEvent = null;
		Scanner noteDown = new Scanner(System.in); //scanner assignment

		while(true) 
		{						
			System.out.println("Number of events scheduled: " + programEvent.numberEvents() + "\n");
			System.out.println("Write it down ... if you want to:\n"
					+ "1. \"create\" - add new event, \n"
					+ "2. \"book\" - book a ticket, \n"
					+ "3. \"cancel\" - cancel your booking \n"
					+ "4. \"show\" - see the list of all events \n"
					+ "5. \"erase\" - delete all scheduled events \n");			
			
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
						System.out.println("Type down new event data (dd/mm/yyyy): ");
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
						    	System.out.println("The date you have chosen has already passed, please insert a future date.");
						    }						    
						}
						catch (Exception e)																							   		  //generic exception management	
						{  		   
							System.out.println("Something went wrong, please retype the date:");
						}	
					}
					
					System.out.println("Insert available seats: ");
					Integer totSeats = Integer.parseInt(noteDown.nextLine());		
					
					//concert class price and time
					System.out.println("Price in €: ");
					Float price = Float.valueOf(noteDown.nextLine());		
					
					int index = 0;
					while (index != 1)
					{
						System.out.println("Type the time (hh:mm) for the new event: ");
						String timeString = noteDown.nextLine();	
						try
						{							
							DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm"); 	//defines the time format to use
						    timeEvent = LocalTime.parse(timeString, formatter); 	//compare and transform string to time format using the above TimeFormatter  
						    index = 1;
						}
						catch (Exception e)	//generic exception management	
						{  		   
							System.out.println("Something went wrong, please retype the time(hh:mm):");
						}	
					}
				    
					userEvent = new Concerts (eventTitle, dataEvent, totSeats, 0, timeEvent ,price);	
					programEvent.addEvent(userEvent);		//added new event to arrayList 
					System.out.println("Ci siamo: " + userEvent.toString());
					break;
				
				//ticket booking
				case "book":
					System.out.println("Event name:");
					String bookedEvent = noteDown.nextLine();
					
					System.out.println("Write down the number of tickets you are interested for:");
					Integer bookedSeats = Integer.parseInt(noteDown.nextLine());				
			
					for( Event event: programEvent.getEvent())
					{
						if(event.title.equals(bookedEvent))
						{
							event.setBookedSeats(bookedSeats);
							//event.getBookedSeats(); 
							System.out.println("Successfully booked: " + userEvent.toString());
						}
					}
					break;
				
				//ticket cancellation
				case "cancel":
					System.out.println("Event name:");
					String canceledSeatsEvent = noteDown.nextLine();
					
					System.out.println("Write down the number of tickets you wanna cancel:");
					Integer cancelSeats = Integer.parseInt(noteDown.nextLine()) * (-1);				
			
					for( Event event: programEvent.getEvent())
					{
						if(event.title.equals(canceledSeatsEvent))
						{
							event.setBookedSeats(cancelSeats);
							//event.getBookedSeats(); 
							System.out.println("Successfully canceled: " + userEvent.toString());
						}
					}
					break;
					
					//event list
				case "show":
					for( Event event: programEvent.getEvent())
					{
						System.out.println(event);
					}
					break;
					
					//clear the entire event list
				case "erase":
					programEvent.cancelAllEvents();
					break;
				
				//try again
				default:
					System.out.println("Try again, "
							+ "write \"create\" if you want to add new event, "
							+ "write down \"book\" if you want to book a ticket. "
							+ "write \"cancel\" if you want to cancel your booking"); 					
			}				
		}		
	}
}
