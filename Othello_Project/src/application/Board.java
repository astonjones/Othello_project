package application;

/**
 * Board class for Othello, includes main gameplay logic like determining available moves
 * 
 * Author: Thomas King
 */
public class Board {

    private int[][] board = new int[8][8];
    private final int BLACK = 1; // represents a black disc
    private final int WHITE = 2; // represents a white disc
    private final int VALID = 5; // represents a valid move location
    public int turn = 1; //flag that represents whose turn it is
    public boolean justPassed = false; //marks if the previous move was a pass. used for detecting a double pass
    public boolean resigned = false; //if someone hits Quit, turn this true
    public boolean timeUp = false;
    private String pattern1 = "[2]+1.*"; //Strings for checking disc sequences
    private String pattern2 = "[1]+2.*";

    /**
     * Default constructor
     */
    public Board() {
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
    public void moves() {
        // iterate over the entire board
        for (int row = 0; row < 8; row++) {
            for (int col = 0; col < 8; col++) {
                if (board[row][col] != 0) {
                    continue;
                }

                boolean isValidMove = false;

                for (int k = 0; k < 8; k++) {
                    String direction = getDiscSequence(row, col, k);
                    if (
                        turn == 1 &&
                        direction.matches(pattern1) ||
                        turn == 2 &&
                        direction.matches(pattern2)
                    ) {
                        isValidMove = true;
                    }
                }
                if (isValidMove) {
                    board[row][col] = VALID;
                }
            }
        }
    }

    /**
     * declares if a move is valid
     * args         x = row number, y = column number
     */
    public boolean isMoveValid(int row, int col) {
        if (row < 0 || col < 0 || row > 7 || col > 7) {
            return false;
        }
        return board[row][col] == VALID;
    }

    /**
     * returns a String showing the sequence of discs in a certain direction from the given starting point
     * args 		x = row number, y = column number
     * 				dir = cardinal direction, 0 = N, 1 = NE ... 7 = NW (clockwise)
     */
    public String getDiscSequence(int row, int col, int dir) {
        String s = "";
        switch (dir) {
            case 0: // North
                {
                    while (row > 0) {
                        s += board[--row][col];
                    }
                }
                break;
            case 1: // North East
                {
                    while (row > 0 && col < 7) {
                        s += board[--row][++col];
                    }
                }
                break;
            case 2: // East
                {
                    while (col < 7) {
                        s += board[row][++col];
                    }
                }
                break;
            case 3: // South East
                {
                    while (row < 7 && col < 7) {
                        s += board[++row][++col];
                    }
                }
                break;
            case 4: // South
                {
                    while (row < 7) {
                        s += board[++row][col];
                    }
                }
                break;
            case 5: // South West
                {
                    while (row < 7 && col > 0) {
                        s += board[++row][--col];
                    }
                }
                break;
            case 6: // West
                {
                    while (col > 0) {
                        s += board[row][--col];
                    }
                }
                break;
            case 7: // North West
                {
                    while (row > 0 && col > 0) {
                        s += board[--row][--col];
                    }
                }
                break;
        }
        return s;
    }

    /**
     * places disc in the given location, and sets up play for the next player
     * args         x = row number, y = column number
     */
    public void placeDisc(int x, int y) {
        board[x][y] = turn;
        for (int k = 0; k < 8; k++) {
            String s = getDiscSequence(x, y, k);
            if (
                turn == 1 &&
                s.matches(pattern1) ||
                turn == 2 &&
                s.matches(pattern2)
            ) {
                int posX = x;
                int posY = y;
                while (s.charAt(0) - '0' != turn) {
                    switch (k) {
                        case 0:
                            {
                                --posX;
                            }
                            break;
                        case 1:
                            {
                                --posX;
                                ++posY;
                            }
                            break;
                        case 2:
                            {
                                ++posY;
                            }
                            break;
                        case 3:
                            {
                                ++posX;
                                ++posY;
                            }
                            break;
                        case 4:
                            {
                                ++posX;
                            }
                            break;
                        case 5:
                            {
                                ++posX;
                                --posY;
                            }
                            break;
                        case 6:
                            {
                                --posY;
                            }
                            break;
                        case 7:
                            {
                                --posX;
                                --posY;
                            }
                            break;
                    }
                    board[posX][posY] = turn;
                    s = s.substring(1);
                }
            }
        }

        changeTurn();
    }
	
	/*
	 *	Change the current player turn, basically just toggle a turn flag
	 */
    public void changeTurn() {
        //toggle flag
        turn = (turn == 2) ? 1 : 2;

        //reset all '5' cells to '0' again
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == 5) {
                    board[i][j] = 0;
                }
            }
        }

        //mark new potential locations
        moves();
    }

	/**
	 * Returns Board object
	 */
    public int[][] getBoard() {
        return board;
    }

	/**
	 * Returns score
	 */
    public int getScore(int type) {
        int ans = 0;
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (board[i][j] == type) {
                    ans++;
                }
            }
        }
        return ans;
    }

    public int getWhiteScore() {
        return getScore(WHITE);
    }

    public int getBlackScore() {
        return getScore(BLACK);
    }

    public int getValidSquares() {
        return getScore(VALID);
    }

    public boolean mustPass() {
        return getValidSquares() == 0;
    }

    public boolean isTied() {
        return getWhiteScore() == getBlackScore();
    }

	/**
	 * Returns a string that indicates the winner of the game
	 */
    public String winner() {
        if (resigned || timeUp) {
            return (
                turn == 1 ? "White is victorious." : "Black is victorious."
            );
        }
        if (isTied()) {
            return "Draw.";
        }
        if (getWhiteScore() > getBlackScore()) {
            return "White is victorious.";
        }
        return "Black is victorious.";
    }
}