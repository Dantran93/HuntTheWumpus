package model;

import java.util.Observable;

/******************************************************************************
 * Bat.java
 * 
 * Purpose: Represents a bat in the game.
 *****************************************************************************/

public class Bat extends Observable
{
	// Fields
	private GridLocation location;
		
		
		
	/**************************************************************************
	 * Bat Constructor ()
	 * 
	 * Purpose: Creates a new Bat. The initial position is (0,0).
	 *************************************************************************/
	
	public Bat ()
	{
		super();
		this.location = new GridLocation(0, 0);
	} // Bat Constructor ()
	
	
	
	/**************************************************************************
	 * getLocation()
	 * 
	 * Purpose: Returns the location of the Hunter.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: GridLocation. The location of the Hunter.
	 *************************************************************************/
		
	public GridLocation getLocation ()
	{
		return location;
	} // getLocation()
	
} // class Bat
