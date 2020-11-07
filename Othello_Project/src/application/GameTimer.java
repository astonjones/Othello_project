package application;

import javafx.scene.control.TextField;
import java.util.Timer;
import java.util.TimerTask;
import javafx.scene.text.Text;

public class GameTimer {
	static int initialInterval = 10;
	static int interval = initialInterval; //default setting is 1 minute
	static Timer timer;
    static final int delay = 1000; //delay is milliseconds before task is to be executed
    static final int period = 1000; //period is time in milliseconds between successive task executions
    TextField text; //update the GUI
    
    public GameTimer(TextField text) {
    	this.text = text;
    }
	
	public void startTimer()
	{
	    timer = new Timer();
	    updateText();
	    System.out.println(interval);
	    timer.scheduleAtFixedRate(new TimerTask() {

	        public void run() {
	            System.out.println(countdown());
	            updateText();
	        }
	    }, delay, period);
	}

	//This decrements the timer by 1 seconds each time
	private final String countdown() {
	    if (interval == 0)
	    {
	        timer.cancel();
	        System.out.println("Opposing player wins");
	    }
	    --interval;
	    // insert method to change textfield...
	    return String.valueOf(interval);
	}
	
	// changes timer back to the initial time that was set
	public void stopTimer()
	{
		timer.cancel();
		this.interval = initialInterval;
	}
	
	// This allows the timer to be set
	public void setTimer(int seconds)
	{
		initialInterval = seconds;
	}
	
	//This gets the current time in seconds left
	public String getTimer()
	{
		return String.valueOf(interval);
	}
	
	// updates the textfield associated with the time
	public void updateText() {
		text.setText(getTimer());
	}
}
