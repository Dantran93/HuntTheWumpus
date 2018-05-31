package view;

import java.util.Observable;
import java.util.Observer;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/******************************************************************************
 * ImageView.java
 * 
 * Purpose: 
 *****************************************************************************/

public class ImageView extends Canvas implements Observer
{
	
	private static final int X = 0;
	private static final int Y = 0;
	
	private static final int WIDTH  = 500;
	private static final int HEIGHT = 500;
	
	
	
	
	
	
	
	
	
	
	private GraphicsContext graphics;
	
	
	
	
	/**************************************************************************
	 * ImageView Constructor ()
	 * 
	 * Purpose:
	 *************************************************************************/
	
	public ImageView ()
	{
		super(WIDTH, HEIGHT);
		
		this.graphics = this.getGraphicsContext2D();
		
		graphics.setFill(Color.BLACK);
		graphics.fillRect(X, Y, WIDTH, HEIGHT);
		
	}
	
	
	
	/*
	 * 
	 */
	
	@Override
	public void update (Observable obs, Object obj)
	{
		
		
	}
	
	
	
	/*
	 * 
	 */
	
	private void drawMap ()
	{
		
	}
	
	
	
	
	
	
	
	
} // class ImageView
