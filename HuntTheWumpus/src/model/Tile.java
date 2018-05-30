package model;

/******************************************************************************
 * Tile.java
 * 
 * Purpose: Represents a tile in the game.
 *****************************************************************************/

public class Tile
{
	// Fields
	private boolean hasFog;
	private boolean hasSlime;
	private boolean hasBlood;
	private boolean hasGoop;
	private boolean hasSlimePit;
	private boolean hasWumpus;
	
	
	
	/**************************************************************************
	 * Tile Constructor ()
	 * 
	 * Purpose: Creates a new tile with nothing on it.
	 *************************************************************************/
	
	public Tile ()
	{
		this.hasFog      = false;
		this.hasSlime    = false;
		this.hasBlood    = false;
		this.hasGoop     = false;
		this.hasSlimePit = false;
		this.hasWumpus   = false;
	} // Tile Constructor ()
	
	
	
	/**************************************************************************
	 * clear()
	 * 
	 * Purpose: Clears everything off of the tile. The tile becomes like
	 * 		brand new.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: void.
	 *************************************************************************/
	
	public void clear ()
	{
		this.hasFog      = false;
		this.hasSlime    = false;
		this.hasBlood    = false;
		this.hasGoop     = false;
		this.hasSlimePit = false;
		this.hasWumpus   = false;
	} // clear()
	
	
	
	/**************************************************************************
	 * toString()
	 * 
	 * Purpose: Returns the string representation of the tile, including any
	 * 		information about the tile.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: String. Representation of the tile.
	 *************************************************************************/
	
	public String toString ()
	{
		String retVal = "[";
		
		if (this.hasSlimePit)
			retVal += "P";
		else if (this.hasSlime)
			retVal += "S";
		else if (this.hasBlood)
			retVal += "B";
		else if (this.hasGoop)
			retVal += "G";
		else if (this.hasWumpus)
			retVal += "W";
		else
			retVal += " ";
		
		return retVal + "]";
	} // toString()
	
	
	
	/**************************************************************************
	 * hasFog()
	 * 
	 * Purpose: Return true if the tile has fog, false otherwise.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: boolean. Whether or not the tile has fog on it.
	 *************************************************************************/
	
	public boolean hasFog ()
	{
		return hasFog;
	} // hasFog()
	
	
	
	/**************************************************************************
	 * setFog()
	 * 
	 * Purpose: Change the status of fog on the tile.
	 * 
	 * Parameters:
	 * 		boolean hasFog -- New status of fog on the tile.
	 * 
	 * Returns: void.
	 *************************************************************************/
	
	public void setFog (boolean hasFog)
	{
		this.hasFog = hasFog;
	} // setFog()
	
	
	
	/**************************************************************************
	 * hasSlime()
	 * 
	 * Purpose: Return true if the tile has slime, false otherwise.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: boolean. Whether or not the tile has slime on it.
	 *************************************************************************/
	
	public boolean hasSlime ()
	{
		return hasSlime;
	} // hasSlime()
	
	
	
	/**************************************************************************
	 * setSlime()
	 * 
	 * Purpose: Change the status of slime on the tile. Places goop instead
	 * 		if there is already blood on the tile.
	 * 
	 * Parameters:
	 * 		boolean hasSlime -- New status of slime on the tile.
	 * 
	 * Returns: void.
	 *************************************************************************/
	
	public void setSlime (boolean hasSlime)
	{
		// Tiles with blood and slime contain goop
		if (this.hasBlood && hasSlime)
			setGoop(true);
		else
			this.hasSlime = hasSlime;
	} // setSlime()
	
	
	
	/**************************************************************************
	 * hasBlood()
	 * 
	 * Purpose: Return true if the tile has blood, false otherwise.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: boolean. Whether or not the tile has blood on it.
	 *************************************************************************/
	
	public boolean hasBlood ()
	{
		return hasBlood;
	} // hasBlood()
	
	
	
	/**************************************************************************
	 * setBlood()
	 * 
	 * Purpose: Change the status of blood on the tile. Places goop instead
	 * 		if there is already slime on the tile.
	 * 
	 * Parameters:
	 * 		boolean hasBlood -- New status of blood on the tile.
	 * 
	 * Returns: void.
	 *************************************************************************/
	
	public void setBlood (boolean hasBlood)
	{
		// Tiles with blood and slime contain goop
		if (this.hasSlime && hasBlood)
			setGoop(true);
		else
			this.hasBlood = hasBlood;
	} // setBlood()
	
	
	
	/**************************************************************************
	 * hasGoop()
	 * 
	 * Purpose: Return true if the tile has goop, false otherwise.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: boolean. Whether or not the tile has goop on it.
	 *************************************************************************/
	
	public boolean hasGoop ()
	{
		return hasGoop;
	} // hasGoop()
	
	
	
	/**************************************************************************
	 * setGoop()
	 * 
	 * Purpose: Change the status of goop on the tile. Clears blood and slime.
	 * 
	 * Parameters:
	 * 		boolean hasGoop -- New status of goop on the tile.
	 * 
	 * Returns: void.
	 *************************************************************************/
	
	public void setGoop (boolean hasGoop)
	{
		// Remove slime and blood to replace with goop
		if (hasGoop)
		{
			this.hasBlood = false;
			this.hasSlime = false;
		}
		
		this.hasGoop = hasGoop;
	} // setGoop()
	
	
	
	/**************************************************************************
	 * hasSlimePit()
	 * 
	 * Purpose: Return true if the tile has a slime pit, false otherwise.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: boolean. Whether or not the tile has a slime pit on it.
	 *************************************************************************/
	
	public boolean hasSlimePit ()
	{
		return hasSlimePit;
	} // hasSlimePit()
	
	
	
	/**************************************************************************
	 * setSlimePit()
	 * 
	 * Purpose: Change the status of a slime pit on the tile.
	 * 
	 * Parameters:
	 * 		boolean hasSlimePit -- New status of a slime pit on the tile.
	 * 
	 * Returns: void.
	 *************************************************************************/
	
	public void setSlimePit (boolean hasSlimePit)
	{
		this.hasSlimePit = hasSlimePit;
	} // setSlimePit()
	
	
	
	/**************************************************************************
	 * hasWumpus()
	 * 
	 * Purpose: Return true if the tile has the wumpus, false otherwise.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: boolean. Whether or not the tile has the wumpus on it.
	 *************************************************************************/
	
	public boolean hasWumpus ()
	{
		return hasWumpus;
	} // hasWumpus()
	
	
	
	/**************************************************************************
	 * setWumpus()
	 * 
	 * Purpose: Change the status of the wumpus on the tile.
	 * 
	 * Parameters:
	 * 		boolean hasWumpus -- New status of the wumpus on the tile.
	 * 
	 * Returns: void.
	 *************************************************************************/
	
	public void setWumpus (boolean hasWumpus)
	{
		this.hasWumpus = hasWumpus;
	} // setWumpus()
	
} // class Tile
