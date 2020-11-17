package application;

import javafx.application.Platform;
import javafx.scene.control.TextField;
import java.awt.event.*;
import javax.swing.*;

public class GameTimer {
	GameBoardUI gameBoardUI;
	int interval = 90;
	int blackInterval = interval;
	int whiteInterval = interval;
	Timer timer;
    final int TIMER_DELAY = 1000; //delay is milliseconds before task is to be executed
    
    //Action listener to perform every second.
    ActionListener taskPerformer = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			if(GameBoardUI.game.getGameBoard().turn == 1) 
			{
				if(blackInterval < 1) 
				{
					gameOver();	
					timer.stop();
				} else {
					blackInterval = blackInterval - 1;
					updateBlackText();
				}
			} else {
				if(whiteInterval < 1) 
				{
					gameOver();	
					timer.stop();
				} else {
					whiteInterval = whiteInterval - 1;
					updateWhiteText();
				}
			}
		}
    };
    
    public GameTimer(GameBoardUI gameBoardUI)
    {
    	this.gameBoardUI = gameBoardUI;
    	setTimer(GameBoardUI.game.getTime());
    	timer = new Timer(TIMER_DELAY, taskPerformer);
    	
    	GameBoardUI.P1Timer.setText(getBlackTime());
    	GameBoardUI.P2Timer.setText(getWhiteTime());
    	System.out.println("game get time is " + GameBoardUI.game.getTime());
    	System.out.println("interval is " + interval);
    	timer.start();
    }
	
	// This allows the timer to be set
	public void setTimer(int seconds)
	{
		interval = seconds;
		blackInterval = interval;
		whiteInterval = interval;
	}
	
	public String getBlackTime()
	{
		return String.valueOf(blackInterval);
	}
	
	public String getWhiteTime()
	{
		return String.valueOf(whiteInterval);
	}
	
	// updates the textfield associated with the time
	public void updateBlackText()
	{
		GameBoardUI.P1Timer.setText(getBlackTime());
	}
	
	public void updateWhiteText() 
	{
		GameBoardUI.P2Timer.setText(getWhiteTime());
	}
	
	public void gameOver()
	{
		gameBoardUI.game.getGameBoard().timeUp = true;
		Platform.runLater(new Runnable() {

			@Override
			public void run() {
				// TODO Auto-generated method stub
				GameBoardUI.showResult();
			}
		});
	}
	
}