package controller;

import java.io.File;
import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import view.ImageView;

/******************************************************************************
 * HuntTheWumpusGUI.java
 * 
 * Purpose: Manages the user interface for the Hunt The Wumpus game.
 *****************************************************************************/

public class HuntTheWumpusGUI extends Application
{
	// Numeric Constants / Dimensions
	private static final int WINDOW_WIDTH  = 600;
	private static final int WINDOW_HEIGHT = 600;
	
	// String Constants / Labels
	private static final String WINDOW_TITLE = "Hunt The Wumpus";
	private static final String GAME_MUSIC   = "music/deadmau5-ID.wav";
	
	
	
	// GUI Components
	private Pane frame;
	private ImageView imageView;
	private Media song;
	private MediaPlayer music;
	
	
	
	/**************************************************************************
	 * main()
	 * 
	 * Purpose: Runs the application.
	 * 
	 * Parameters:
	 * 		String[] args -- Command line arguments. Not used in the game.
	 * 
	 * Returns: void.
	 *************************************************************************/
	
	public static void main (String[] args)
	{
		launch(args);
	} // main()
	
	
	
	/**************************************************************************
	 * start()
	 * 
	 * Purpose: Initializes and displays the window. The music starts.
	 * 
	 * Parameters:
	 * 		Stage stage -- Main application window.
	 * 
	 * Returns: void.
	 *************************************************************************/
	
	@Override
	public void start (Stage stage) throws Exception
	{
		initWindow(stage);
		addImageView();
		stage.show();
		
		song = new Media(new File(GAME_MUSIC).toURI().toString());
		music = new MediaPlayer(song);
		music.play();
	} // start()
	
	
	
	/**************************************************************************
	 * initWindow()
	 * 
	 * Purpose: Initializes the GUI window.
	 * 
	 * Parameters:
	 * 		Stage stage -- Main application window.
	 * 
	 * Returns: void.
	 *************************************************************************/
	
	private void initWindow (Stage stage)
	{
		Pane root = new Pane();
		Scene scene = new Scene(root, WINDOW_WIDTH, WINDOW_HEIGHT, Color.DARKSLATEGRAY);
		stage.setScene(scene);
		stage.setTitle(WINDOW_TITLE);
		stage.setResizable(false);
		frame = new Pane();
		scene.setRoot(frame);
	} // initWindow()
	
	
	
	/**************************************************************************
	 * addImageView()
	 * 
	 * Purpose: Adds the image view for the game to the GUI.
	 * 
	 * Parameters: None.
	 * 
	 * Returns: void.
	 *************************************************************************/
	
	private void addImageView () throws FileNotFoundException
	{
		imageView = new ImageView();
		imageView.setTranslateX((WINDOW_WIDTH - imageView.getWidth()) / 2 + 5);
		imageView.setTranslateY((WINDOW_HEIGHT - imageView.getHeight()) / 2 + 5);
		frame.getChildren().add(imageView);
	} // addImageView()
	
} // class HuntTheWumpusGUI
