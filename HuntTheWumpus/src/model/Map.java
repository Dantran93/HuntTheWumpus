package model;

import java.util.Random;

/******************************************************************************
 * Map.java
 * 
 * Purpose: Represents a map of tiles in the game.
 *****************************************************************************/

public class Map
{
	// Constants
	private static final int SIZE           = 10;
	
	
	
	// Fields
	private Tile[][] tiles;
	
	
	
	/**************************************************************************
	 * Map Constructor ()
	 * 
	 * Purpose: 
	 *************************************************************************/
	
	public Map ()
	{
		this.tiles = new Tile[SIZE][SIZE];
		
		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++)
				this.tiles[i][j] = new Tile();
		
		placeSlimePits();
	} // Map Constructor ()
	
	
	
	/**************************************************************************
	 * getTile()
	 * 
	 * Purpose:
	 * 
	 * Parameters:
	 * 		int row --
	 * 		int column --
	 * 
	 * Returns: Tile.
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
	 * Purpose:
	 * 
	 * Parameters:
	 * 
	 * Returns:
	 *************************************************************************/
	
	public String toString ()
	{
		String retVal = "";
		
		for (int i = 0; i < SIZE; i++)
		{
			for (int j = 0; j < SIZE; j++)
				retVal += tiles[i][j].toString();
			retVal += "\n";
		}
		
		return retVal;
	} // toString()
	
	
	
	/**************************************************************************
	 * placeSlimePits()
	 * 
	 * Purpose:
	 * 
	 * Parameters:
	 * 
	 * Returns:
	 *************************************************************************/
	
	private void placeSlimePits ()
	{
		// Number of slime pits ranges from 3 to 5
		Random rand = new Random();
		int numSlimePits = rand.nextInt(3) + 3;
		
		int row, column;
		for (int i = 0; i < numSlimePits; i++)
		{
			// Keep choosing random locations until a location
			// without a slime pit is chosen
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
	} // 
	
	
	
	/**************************************************************************
	 * 
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	
} // class Map
