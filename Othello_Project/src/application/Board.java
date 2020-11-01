package application;

/**
 * 
 */
public class Board
{
	private int[][] board = new int[8][8];

	private final int BLACK = 1; // represents a black disc
	private final int WHITE = 2; // represents a white disc
	private final int VALID = 5; // represents a valid move location
	
	public int turn = 1; //flag that represents whose turn it is
	
	String pattern1 = "[2]+1.*";//Strings for checking disc sequences
    String pattern2 = "[1]+2.*";
	
	/**
	 * Default constructor
	 */
	public Board()
	{
		// when a new board is initialized, set [3][3] and [4][4] to white. set [3][4] and [4][3] to black
		board[3][3] = WHITE;
		board[4][4] = WHITE;
		board[3][4] = BLACK;
		board[4][3] = BLACK;
		moves();
	}	

	/**
	 *  Determines all available moves
	 */
	public void moves()
	{
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
		for(int i = 0; i<8; i++)
        {
            for(int j = 0; j<8; j++)
            {
                if(board[i][j] != 0)
                {
                    continue;
                }
                
                boolean isValidMove= false;
                
                for(int k = 0; k<8; k++)
                {
                	String direction = getDiscSequence(i, j, k);
                	if(turn == 1 && direction.matches(pattern1) || turn == 2 && direction.matches(pattern2))
                    {
                        isValidMove = true;
                    }
                }
                if(isValidMove)
                {
                	board[i][j] = VALID;
                }
            }
        }
		
	}

	/**
	 * declares if a move is valid
	 * args         x = row number, y = column number
	 */
	public boolean isMoveValid(int x, int y)
	{
		return board[x][y] == VALID;
	}
	
	/**
	 * returns a String showing the sequence of discs in a certain direction from the given starting point
	 * args 		x = row number, y = column number
	 * 				dir = cardinal direction, 0 = N, 1 = NE ... 7 = NW (clockwise)
	 */
	public String getDiscSequence(int x, int y, int dir)
	{
		String s = "";
		switch(dir)
		{
		case 0:
		{
			while(x > 0)
	        {
	            s += board[--x][y];
	        }
		} break;
		case 1:
		{
			while(x > 0 && y < 7)
            {
                s += board[--x][++y];
            }
		} break;
		case 2:
		{
			while(y < 7)
	        {
	            s += board[x][++y];
	        }
		} break;
		case 3:
		{
			while(x < 7 && y < 7)
	        {
	            s += board[++x][++y];
	        }
		} break;
		case 4:
		{
			while(x < 7)
	        {
	            s += board[++x][y];
	        }
		} break;
		case 5:
		{
			while(x < 7 && y > 0)
	        {
	            s += board[++x][--y];
	        }
		} break;
		case 6:
		{
			while(y > 0)
	        {
	            s += board[x][--y];
	        }
		} break;
		case 7:
		{
			while(x > 0 && y > 0)
	        {
	            s += board[--x][--y];
	        }
		} break;
		}
        return s;
	}
	
	/**
	 * places disc in the given location, and sets up play for the next player
	 * args         x = row number, y = column number
	 */
	public void updateBoard(int x, int y)
	{
		board[x][y] = turn;
		for(int k = 0; k<8; k++)
		{
			String s = getDiscSequence(x, y, k);
			if(turn == 1 && s.matches(pattern1) || turn == 2 && s.matches(pattern2))
			{
				int posX = x;
				int posY = y;
				while(s.charAt(0) - '0' != turn)
				{
					switch(k)
					{
					case 0:
					{
						--posX;
					} break;
					case 1:
					{
						--posX;
						++posY;
					} break;
					case 2:
					{
						++posY;
					} break;
					case 3:
					{
						++posX;
						++posY;
					} break;
					case 4:
					{
						++posX;
					} break;
					case 5:
					{
						++posX;
						--posY;
					} break;
					case 6:
					{
						--posY;
					} break;
					case 7:
					{
						--posX;
						--posY;
					} break;
					}
					board[posX][posY] = turn;
					s = s.substring(1);
				}
			}
		}
		
		//toggle flag
		turn = (turn == 2) ? 1 : 2;
		
		//reset all '5' cells to '0' again
		for(int i = 0; i<8; i++)
		{
			for(int j = 0; j<8; j++)
			{
				if(board[i][j] == 5)
				{
					board[i][j] = 0;
				}
			}
		}
		
		
		
		//mark new potential locations
		moves();
	}
	
	public int[][] getBoard()
	{
		return board;
	}
}