package controller;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import model.Map;
import view.ImageView;

/******************************************************************************
 * HuntTheWumpusGUI.java
 * 
 * Purpose:
 *****************************************************************************/

public class HuntTheWumpusGUI extends Application
{
	private static final int WINDOW_WIDTH  = 600;
	private static final int WINDOW_HEIGHT = 600;
	
	private static final String WINDOW_TITLE = "Hunt The Wumpus";
	
	
	
	
	private Pane frame;
	private ImageView imageView;
	private Map map;
	
	
	
	/**************************************************************************
	 * 
	 *************************************************************************/
	
	public static void main (String[] args)
	{
		launch(args);
	} // main()
	
	
	
	/*
	 * 
	 */
	
	@Override
	public void start(Stage stage) throws Exception
	{
		initWindow(stage);
		addImageView();
		
		
		map = new Map();
		map.initialize();
		
		
		
		stage.show();
	}
	
	
	
	
	
	
	/*
	 * 
	 */
	
	private void initWindow (Stage stage)
	{
		// Initialize primary window
		Pane root = new Pane();
		Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT);
		stage.setScene(scene);
		stage.setTitle(WINDOW_TITLE);
		stage.setResizable(false);
		frame = new Pane();
		scene.setRoot(frame);
	}
	
	
	
	/*
	 * 
	 */
	
	private void addImageView ()
	{
		imageView = new ImageView();
		imageView.setTranslateX((WINDOW_WIDTH - imageView.getWidth()) / 2 + 5);
		imageView.setTranslateY((WINDOW_HEIGHT - imageView.getHeight()) / 2 + 5);
		
		frame.getChildren().add(imageView);
		
		
	}
	
	

	
	
	
	
} // class HuntTheWumpusGUI
