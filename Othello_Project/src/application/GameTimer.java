package application;

import java.util.Timer;
import java.util.TimerTask;

public class GameTimer {
	static int interval = 60; //default setting is 1 minute
	static Timer timer;
    static final int delay = 1000; //delay is milliseconds before task is to be executed
    static final int period = 1000; //period is time in milliseconds between successive task executions
    
    public GameTimer() {
    	
    }
	
	public void startTimer()
	{
		System.out.print("Game started");
	    timer = new Timer();
	    System.out.println(interval);
	    timer.scheduleAtFixedRate(new TimerTask() {

	        public void run() {
	            System.out.println(countdown());

	        }
	    }, delay, period);
	}

	//This decrements the timer by 1 seconds each time
	private final int countdown() {
	    if (interval == 0)
	    {
	        timer.cancel();
	        System.out.println("Opposing player wins");
	    }
	    return --interval;
	}
	
	private void setTimer(int seconds)
	{
		interval = seconds;
	}
}
