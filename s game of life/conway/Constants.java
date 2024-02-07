package conway;

public class Constants
{
    public static final int BOARD_SIZE = 25;
    // Valid board values
    public static final boolean DEAD = false;
    public static final boolean ALIVE = true;

    // Game states
    public static final int STANDBY = 1;
    public static final int GET_COMMAND = 2;
    public static final int START = 3;
    public static final int CHANGE_BOARD = 4;
    public static final int SHOW_BOARD = 5;
    public static final int PAUSE = 6;
    public static final int RESET = 7;
    public static final int QUIT_PROGRAM = 8;
    
    // Commands
    public static final String TOGGLE_COMMAND = "toggle";
    public static final String START_COMMAND = "start";
    public static final String PAUSE_COMMAND = "pause";
    public static final String RESET_COMMAND = "reset";
    public static final String SET_GRID_SIZE_COMMAND = "set_board_size";
    public static final String EXIT_COMMAND = "exit";
    public static final String HELP_COMMAND = "help";
    
    // Strings
    public static final String ASK_COMMAND = "Please enter a command, type 'help' to see list of commands.";
    public static final String INVALID_COMMAND = "Unknown command, type 'help' to see list of commands.";
    public static final String COMMANDS = TOGGLE_COMMAND + "\n" + START_COMMAND + "\n" + PAUSE_COMMAND + "\n" + RESET_COMMAND + "\n" + SET_GRID_SIZE_COMMAND + "\n" + EXIT_COMMAND;
    public static final String ASK_ROW = "Please enter row";
    public static final String ASK_COL = "Please enter column";
    public static final String INVALID_CELL = "Cell %d, %d is not a valid cell. Please retry.";
    public static final String ALIVE_CELL = "##";
    public static final String DEAD_CELL = "[]";
}