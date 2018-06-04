package model;

import java.util.List;
import java.util.Random;

/******************************************************************************
 * Map.java
 * 
 * Purpose: Represents a map of tiles in the game.
 *****************************************************************************/

public class Map
{
	// Constants
	private static final int SIZE = 10;
	
	
	
	// Fields
	private Tile[][] tiles;
	private List<Bat> bats;
	private Hunter hunter;
	
	
	
	/**************************************************************************
	 * Map Constructor ()
	 * 
	 * Purpose: Creates and initializes a new map that is SIZExSIZE cells.
	 * 		The slime pits and Wumpus are randomly placed on the map, along
	 * 		with any slime and blood. Only blood and slime overlap to create
	 * 		goop.
	 *************************************************************************/
	
	public Map ()
	{
		this.tiles = new Tile[SIZE][SIZE];
		
		for (int row = 0; row < SIZE; row++)
			for (int column = 0; column < SIZE; column++)
				this.tiles[row][column] = new Tile();
	} // Map Constructor ()
	
	
	
	/**************************************************************************
	 * initialize()
	 * 
	 * Purpose: Places the slime pits and Wumpus on the map, along with the
	 * 		slime and blood.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: void.
	 *************************************************************************/
	
	public void initialize ()
	{
		placeSlimePits();
		placeWumpus();
		placeHunter();
	} // initialize()
	
	
	
	/**************************************************************************
	 * getSize()
	 * 
	 * Purpose: Returns the size of the map.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: int. The size of the map.
	 *************************************************************************/
	
	public int getSize ()
	{
		return SIZE;
	} // getSize()
	
	
	
	/*
	 * 
	 */
	
	public Hunter getHunter ()
	{
		return hunter;
	}
	
	
	
	/**************************************************************************
	 * clear()
	 * 
	 * Purpose: Clears every tile on the map of the slime pits, Wumpus, blood,
	 * 		slime, and goop.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: void.
	 *************************************************************************/
	
	public void clear ()
	{
		for (int row = 0; row < SIZE; row++)
			for (int column = 0; column < SIZE; column++)
				tiles[row][column].clear();
	} // clear()
	
	
	
	/**************************************************************************
	 * getTile()
	 * 
	 * Purpose: Returns the tile on the map with the given row and column
	 * 		indices.
	 * 
	 * 		Throws IllegalArgumentxception if the coordinates are out of bounds.
	 * 
	 * Parameters:
	 * 		int row -- Row index in the map.
	 * 		int column -- Column index in the map.
	 * 
	 * Returns: Tile. The tile in the map with the given coordinates.
	 *************************************************************************/
	
	public Tile getTile (int row, int column)
	{
		// Out of bounds, throw exception
		if (row < 0 || row >= SIZE || column < 0 || column >= SIZE)
			throw new IllegalArgumentException();
		
		return tiles[row][column];
	} // getTile()
	
	
	
	/**************************************************************************
	 * toString()
	 * 
	 * Purpose: Returns the string (textual) representation of the map.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: String. The string (textual) representation of the map.
	 *************************************************************************/
	
	public String toString ()
	{
		String retVal = "";
		
		for (int row = 0; row < SIZE; row++)
		{
			for (int column = 0; column < SIZE; column++)
				retVal += tiles[row][column].toString();
			retVal += "\n";
		}
		
		return retVal;
	} // toString()
	
	
	
	/**************************************************************************
	 * placeSlimePits()
	 * 
	 * Purpose: Randomly places 3-5 slime pits on the map, along with slime
	 * 		around each pit in north, south, east, and west positions.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: void.
	 *************************************************************************/
	
	private void placeSlimePits ()
	{
		// Number of slime pits ranges from 3 to 5
		Random rand = new Random();
		int numSlimePits = rand.nextInt(3) + 3;
		
		int row, column;
		for (int i = 0; i < numSlimePits; i++)
		{
			// Find a random spot on the map that is not already occupied
			while (true)
			{
				row    = rand.nextInt(SIZE);
				column = rand.nextInt(SIZE);
				
				if (! tiles[row][column].hasSlimePit())
				{
					tiles[row][column].setSlimePit(true);
					placeSlime(row-1, column);
					placeSlime(row+1, column);
					placeSlime(row, column-1);
					placeSlime(row, column+1);
					break;
				}
			}
		}
	} // placeSlimePits()
	
	
	
	/**************************************************************************
	 * placeSlime()
	 * 
	 * Purpose: Places slime on the tile with the given coordinates. If the
	 * 		location is off the edge, the location wraps around.
	 * 
	 * Parameters:
	 * 		int row -- Row coordinate on the map.
	 * 		int column -- Column coordinate on the map.
	 * 
	 * Returns: void.
	 *************************************************************************/
	
	private void placeSlime (int row, int column)
	{
		row = row % SIZE;
		if (row < 0)
			row = row + SIZE;
		
		column = column % SIZE;
		if (column < 0)
			column = column + SIZE;
		
		if (! tiles[row][column].hasSlimePit())
			tiles[row][column].setSlime(true);
	} // placeSlime()
	
	
	
	/**************************************************************************
	 * placeWumpus()
	 * 
	 * Purpose: Randomly places the Wumpus on the map, along with blood all
	 * 		around the Wumpus.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: void.
	 *************************************************************************/
	
	private void placeWumpus ()
	{
		Random rand = new Random();
		
		// Find a random spot on the map that is not already occupied
		int row, column;
		while (true)
		{
			row    = rand.nextInt(SIZE);
			column = rand.nextInt(SIZE);
			
			if (! (tiles[row][column].hasSlimePit() || tiles[row][column].hasSlime()))
			{
				tiles[row][column].setWumpus(true);
				placeBlood(row-1, column);
				placeBlood(row-2, column);
				placeBlood(row+1, column);
				placeBlood(row+2, column);
				placeBlood(row,   column-1);
				placeBlood(row,   column-2);
				placeBlood(row,   column+1);
				placeBlood(row,   column+2);
				placeBlood(row-1, column-1);
				placeBlood(row-1, column+1);
				placeBlood(row+1, column-1);
				placeBlood(row+1, column+1);
				break;
			}
		}
	} // placeWumpus()
	
	
	
	/**************************************************************************
	 * placeBlood()
	 * 
	 * Purpose: Places blood on the tile with the given coordinates. If the
	 * 		location is off the edge, the location wraps around.
	 * 
	 * Parameters:
	 * 		int row -- Row coordinate on the map.
	 * 		int column -- Column coordinate on the map.
	 * 
	 * Returns: void.
	 *************************************************************************/
	
	private void placeBlood (int row, int column)
	{
		row = row % SIZE;
		if (row < 0)
			row = row + SIZE;
		
		column = column % SIZE;
		if (column < 0)
			column = column + SIZE;
		
		if (! (tiles[row][column].hasSlimePit() || tiles[row][column].hasWumpus()))
			tiles[row][column].setBlood(true);
	} // placeBlood()
	
	
	
	/*
	 * 
	 */
	
	private void placeHunter ()
	{
		hunter = new Hunter();
		Random rand = new Random();
		int row, column;
		
		while (true)
		{
			row    = rand.nextInt(SIZE);
			column = rand.nextInt(SIZE);
			
			if (tiles[row][column].isEmpty())
			{
				hunter.getLocation().setRow(row);
				hunter.getLocation().setColumn(column);
				tiles[row][column].setFog(false);
				break;
			}
		}
	} //
	
	
	
	
	
	
} // class Map
