package application;

import java.util.*;

/**
 * 
 */
public class Board {

	private int[][] board = {   {0,0,0,0,0,0,0,0},
					     		{0,0,0,0,0,0,0,0},
								{0,0,0,0,0,0,0,0},
								{0,0,0,0,0,0,0,0},
								{0,0,0,0,0,0,0,0},
								{0,0,0,0,0,0,0,0},
								{0,0,0,0,0,0,0,0},
								{0,0,0,0,0,0,0,0} };

	private final int BLACK = 1; // represents a white disk
	private final int WHITE = 2; // represents a black disk
	private final int VALID = 5; // represents a valid move location
	/**
	 * Default constructor
	 */
	public Board() {
		// when a new board is initialized, set [3][3] and [4][4] to white. set [3][4] and [4][3] to black
		board[3][3] = WHITE;
		board[4][4] = WHITE;
		board[3][4] = BLACK;
		board[4][3] = BLACK;
	}	

	/**
	 *  Determins all available moves
	 *  args	int turn - 1 is white players turn, 2 is black players turn
	 */
	public void moves(int turn) {
		// Find all tiles, black or white (1 or 2), opposite of turn
		// If its black's turn find all white tiles. 
		// per tile we must check N, NE, E, SE, S, SW, W, NW
		// NE is opposite of SW, SE of NW. 


		// ex BLACK Turn, so we are looking at white tile x. 
		// if black tile is directly N of white, and South is free then South is valid move for black
			// if black is directly <cardinal direction> and opposite direction is free then that direction is valid
		// if white tile is North, recursivly check North until black tile OR out of bound. 
			// if a black tile is discovered. go to original white tile, check south for empty space or out of bounds.
				// if empty space, then it is a valid move


	}

	/**
	 * 
	 */
	public boolean isMoveValid() {
		// TODO implement here
	}

	/**
	 * 
	 */
	public void updateBoard() {
		// TODO implement here
	}

}