package org.eventi.java;

import java.util.ArrayList;
import java.util.List;

public class ProgramEvents {
	private String title;
	private ArrayList<Event> event;
	
	public ProgramEvents (String title, ArrayList<Event> event)
	{
		this.title = title;
		this.event = new ArrayList<Event>();
	}
	
	public void addEvent (Event eventTitle)
	{
		this.event.add(eventTitle);
	}
	
	public List<Event> getEvent ()
	{
		return this.event;
	}
	
	public int numberEvents ()
	{
		return this.event.size();
	}
	
	public void setEvent(ArrayList<Event> event) {
		this.event = event;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void cancelAllEvents ()
	{
		this.event.clear();
	}
	
}
