package view;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Observable;
import java.util.Observer;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import model.ImageLibrary;
import model.Map;

/******************************************************************************
 * ImageView.java
 * 
 * Purpose: 
 *****************************************************************************/

public class ImageView extends Canvas implements Observer
{
	// Constants
	private static final int X = 0;
	private static final int Y = 0;
	
	private static final int WIDTH  = 500;
	private static final int HEIGHT = 500;
	
	private static final int TILE_SIZE = 50;
	
	
	
	// Fields
	private Map map;
	private GraphicsContext graphics;
	
	private Image bat;
	private Image blood;
	private Image fog;
	private Image goop;
	private Image ground;
	private Image hunter;
	private Image slime;
	private Image slimepit;
	private Image wumpus;
	
	
	
	/**************************************************************************
	 * ImageView Constructor ()
	 * 
	 * Purpose:
	 * @throws FileNotFoundException 
	 *************************************************************************/
	
	public ImageView () throws FileNotFoundException
	{
		super(WIDTH, HEIGHT);
		this.graphics = this.getGraphicsContext2D();
		
		map = new Map();
		map.initialize();
		
		loadImages();
		drawMap();
	} // 
	
	
	
	/*
	 * 
	 */
	
	private void loadImages () throws FileNotFoundException
	{
		ground   = new Image(new FileInputStream(ImageLibrary.GROUND));
		bat      = new Image(new FileInputStream(ImageLibrary.BAT));
		blood    = new Image(new FileInputStream(ImageLibrary.BLOOD));
		fog      = new Image(new FileInputStream(ImageLibrary.FOG));
		goop     = new Image(new FileInputStream(ImageLibrary.GOOP));
		hunter   = new Image(new FileInputStream(ImageLibrary.HUNTER));
		slime    = new Image(new FileInputStream(ImageLibrary.SLIME));
		slimepit = new Image(new FileInputStream(ImageLibrary.SLIMEPIT));
		wumpus   = new Image(new FileInputStream(ImageLibrary.WUMPUS));
	} // loadImages()
	
	
	
	
	
	/*
	 * 
	 */
	
	@Override
	public void update (Observable obs, Object obj)
	{
		drawMap();
	}
	
	
	
	/*
	 * 
	 */
	
	private void drawMap ()
	{
		for (int row = 0; row < map.getSize(); row++)
		{
			for (int column = 0; column < map.getSize(); column++)
			{
				int tileRow    = row * TILE_SIZE;
				int tileColumn = column * TILE_SIZE;
				
				if (map.getTile(row, column).hasFog())
					graphics.drawImage(fog, tileColumn, tileRow);
				else
				{
					graphics.drawImage(ground, tileColumn, tileRow);
					
					if (map.getTile(row, column).hasSlimePit())
						graphics.drawImage(slimepit, tileColumn, tileRow);
					if (map.getTile(row, column).hasSlime())
						graphics.drawImage(slime, tileColumn, tileRow);
					if (map.getTile(row, column).hasBlood())
						graphics.drawImage(blood, tileColumn, tileRow);
					if (map.getTile(row, column).hasGoop())
						graphics.drawImage(goop, tileColumn, tileRow);
					if (map.getTile(row, column).hasWumpus())
						graphics.drawImage(wumpus, tileColumn, tileRow);
					
					graphics.drawImage(hunter, map.getHunter().getLocation().getColumn()*TILE_SIZE,
										   	   map.getHunter().getLocation().getRow()*TILE_SIZE);
				}
			}
		}
	} // drawMap()
	
	
	
	
	
	
	
	
} // class ImageView
