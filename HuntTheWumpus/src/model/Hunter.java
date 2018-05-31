package model;

import java.util.Observable;

/******************************************************************************
 * Hunter.java
 * 
 * Purpose: Represents the Hunter in the game.
 *****************************************************************************/

public class Hunter extends Observable
{
	// Fields
	private GridLocation location;
	
	
	
	/**************************************************************************
	 * Hunter Constructor ()
	 * 
	 * Purpose: Creates a new Hunter. The initial position is (0,0).
	 *************************************************************************/
	
	public Hunter ()
	{
		super();
		this.location = new GridLocation(0, 0);
	} // Hunter Constructor ()
	
	
	
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
	
} // class Hunter
