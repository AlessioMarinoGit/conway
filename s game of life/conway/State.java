package conway;

/**
 * Write a description of class State here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class State
{
    private int gameState = Constants.STANDBY;
    private boolean[][] board = new boolean[Constants.BOARD_SIZE][Constants.BOARD_SIZE];
    
    public static int clamp(int value, int min, int max) {
        return Math.max(min, Math.min(max, value));
    }
    
    public boolean checkDeath(int row, int col) {
        int surrounding = 0;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (board[this.clamp(x, 0, Constants.BOARD_SIZE-1)][this.clamp(y, 0, Constants.BOARD_SIZE-1)] == Constants.ALIVE) {
                    surrounding++;
                }
            }
        }
        
        if (surrounding < 2 && surrounding > 3) {
            return false;
        }
        
        return true;
    }
    
    public boolean checkBorn(int row, int col) {
        int surrounding = 0;
        for (int x = -1; x <= 1; x++) {
            for (int y = -1; y <= 1; y++) {
                if (board[this.clamp(x, 0, Constants.BOARD_SIZE-1)][this.clamp(y, 0, Constants.BOARD_SIZE-1)] == Constants.ALIVE) {
                    surrounding++;
                }
            }
        }
        
        if (surrounding == 3) {
            return true;
        }
        
        return false;
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
    
    public boolean isValidCommand(String command) {
        if (command.equals(Constants.TOGGLE_COMMAND) || command.equals(Constants.START_COMMAND) || command.equals(Constants.PAUSE_COMMAND) || command.equals(Constants.RESET_COMMAND) || command.equals(Constants.SET_GRID_SIZE_COMMAND) || command.equals(Constants.EXIT_COMMAND) || command.equals(Constants.HELP_COMMAND)) {
            return true;
        }
        return false;
    }
    
    public void toggleCommand(int x, int y) {
        this.setBoardCell(true, x, y);
        System.out.println(this.getBoardCell(x,y));
        System.out.println(this.getBoardCell(x+1,y+1));
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

    public void setBoardCell(boolean value, int row, int col) {
          this.board[row][col] = value;
    }

    public void toggleBoardCell(int row, int col) {
        this.board[row][col] = !this.board[row][col];
    }
}
