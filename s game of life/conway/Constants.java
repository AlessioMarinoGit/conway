package conway;

public class Constants
{
    public static final int BOARD_SIZE = 10;
    public static final int MAX_STEPS = 1000;
    public static final int DELAY = 200;
    // Valid board values
    public static final int DEAD = 0;
    public static final int ALIVE = 1;

    // Game states
    public static final int STANDBY = 1;
    public static final int GET_COMMAND = 2;
    public static final int RUN_COMMAND = 3;
    public static final int RUN = 4;
    public static final int CHANGE_BOARD = 5;
    public static final int SHOW_BOARD = 6;
    public static final int RESET = 7;
    public static final int QUIT_PROGRAM = 8;
    
    // Commands
    public static final String TOGGLE_COMMAND = "toggle";
    public static final String START_COMMAND = "run";
    public static final String RESET_COMMAND = "reset";
    public static final String SET_GRID_SIZE_COMMAND = "set_board_size";
    public static final String EXIT_COMMAND = "exit";
    public static final String HELP_COMMAND = "help";
    
    // Strings
    public static final String ASK_COMMAND = "Please enter a command, type 'help' to see list of commands.";
    public static final String INVALID_COMMAND = "Unknown command, type 'help' to see list of commands.";
    public static final String COMMANDS = (
    TOGGLE_COMMAND + ": turns on and off a cell" + "\n" 
    + START_COMMAND + ": runs the game for a certain amount of defined steps" + "\n" 
    + RESET_COMMAND + ": resets the grid" + "\n" 
    + SET_GRID_SIZE_COMMAND + ": sets the grid size" + "\n" 
    + EXIT_COMMAND + ": exits the program"
    );
    public static final String ASK_ROW = "Please enter row";
    public static final String ASK_COL = "Please enter column";
    public static final String ASK_STEPS = "Please enter steps";
    public static final String INVALID_STEPS = "Invalid number of steps. Max steps is " + MAX_STEPS;
    public static final String INVALID_CELL = "Cell %d, %d is not a valid cell. Please retry.";
    public static final String ALIVE_CELL = ":D";
    public static final String DEAD_CELL = "[]";
    public static final String SEPERATION_BAR = "--";
}