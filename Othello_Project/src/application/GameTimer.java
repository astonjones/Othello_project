package application;

import javafx.scene.control.TextField;
import java.awt.event.*;
import javax.swing.*;

public class GameTimer {
	Game game;
	int interval = 90;
	Timer timer;
    final int TIMER_DELAY = 1000; //delay is milliseconds before task is to be executed
    TextField text; //update the GUI
    
    //Action listener to perform every second.
    ActionListener taskPerformer = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(interval == 0)
			{
				timer.stop();
				game.getGameBoard().timeUp = true;
				System.out.println("Timer ENDS!");
			} else {
			interval = interval - 1;
			updateText();
			}
		}
    	
    };
    
    public GameTimer(TextField text, Game game)
    {
    	this.game = game;
    	this.text = text;
    	this.interval = game.getTime();
    	this.text.setText(getTimer());
    	timer = new Timer(TIMER_DELAY, taskPerformer);
    }
	
	public void startTimer()
	{
	    timer.start();
	}
	
	// changes timer back to the initial time that was set
	public void stop()
	{
		timer.stop();
	}
	
	// This allows the timer to be set
	public void setTimer(int seconds)
	{
		interval = seconds;
	}
	
	//This gets the current time in seconds left
	public String getTimer()
	{
		return String.valueOf(interval);
	}
	
	public boolean isRunning()
	{
		if(timer.isRunning())
			return true;
		return false;
	}
	
	// updates the textfield associated with the time
	public void updateText()
	{
		this.text.setText(getTimer());
	}
	
}