package model;

/******************************************************************************
 * GridLocation.java
 * 
 * Purpose: Represents a location on a grid, with row and column coordinates.
 *****************************************************************************/

public class GridLocation
{
	// Fields
	private int row;
	private int column;
	
	
	
	/**************************************************************************
	 * GridLocation Constructor (int, int)
	 * 
	 * Purpose: Creates a new GridLocation with the given row and column.
	 *************************************************************************/
	
	public GridLocation (int row, int column)
	{
		this.row = row;
		this.column = column;
	} // GridLocation Constructor (int, int)
	
	
	
	/**************************************************************************
	 * getRow()
	 * 
	 * Purpose: Returns the row coordinate.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: int. The row coordinate.
	 *************************************************************************/
	
	public int getRow ()
	{
		return row;
	} // getRow()
	
	
	
	/**************************************************************************
	 * setRow()
	 * 
	 * Purpose: Changes the row coordinate to a new value.
	 * 
	 * Parameters:
	 * 		int newRow -- New value for the row.
	 * 
	 * Returns: void.
	 *************************************************************************/
	
	public void setRow (int newRow)
	{
		row = newRow;
	} // setRow()
	
	
	
	/**************************************************************************
	 * getColumn()
	 * 
	 * Purpose: Returns the column coordinate.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: int. The column coordinate.
	 *************************************************************************/
	
	public int getColumn ()
	{
		return column;
	} // getColumn()
	
	
	
	/**************************************************************************
	 * setColumn()
	 * 
	 * Purpose: Changes the column coordinate to a new value.
	 * 
	 * Parameters:
	 * 		int newColumn -- New value for the column.
	 * 
	 * Returns: void.
	 *************************************************************************/
	
	public void setColumn (int newColumn)
	{
		column = newColumn;
	} // setColumn()
	
	
	
	/**************************************************************************
	 * equals()
	 * 
	 * Purpose: Compares the row and column coordinates between two locations.
	 * 
	 * Parameters:
	 * 		GridLocation other -- The other location to compare with.
	 * 
	 * Returns: boolean. True if the row and column coordinates between the
	 * 		two locations are equal, false otherwise.
	 *************************************************************************/
	
	public boolean equals (GridLocation other)
	{
		return this.row == other.row && this.column == other.column;
	} // equals()
	
} // class GridLocation
