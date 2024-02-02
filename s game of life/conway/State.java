package conway;

/**
 * Write a description of class State here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class State
{
    private int gameState = Constants.PREPARE;
    private boolean[][] board = new boolean[Constants.BOARD_SIZE][Constants.BOARD_SIZE];

    public boolean checkDeath(int row, int col) {
        int surrounding = 0;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                
            }
        }
        return true;
    }
    public boolean checkBorn(int row, int col) {
        return true;
    }

    public void Step() {
        for (int x = 0; x < Constants.BOARD_SIZE; x++) {
            for (int y = 0; y < Constants.BOARD_SIZE; y++) {
                if (board[x][y] == Constants.ALIVE) {
                    board[x][y] = this.checkDeath(x, y);
                } else {
                    board[x][y] = this.checkBorn(x,y);
                }
            }
        }
    }

    public int getGameState() 
    {
        return this.gameState;
    }

    public void setGameState(int gameState) {
        this.gameState = gameState;
    }

    public boolean getBoardCell(int row, int col) {
        return this.board[row][col];
    }

    public void toggleBoardCell(int row, int col) {
        this.board[row][col] = !this.board[row][col];
    }
}
