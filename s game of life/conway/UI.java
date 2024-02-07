package conway;
import java.util.Scanner;

public class UI
{
    State state = new State();
    Scanner scanner;

    public UI() {
        scanner = new Scanner(System.in);
    }

    public int getRow() {
        int row = 0;

        while (row < 1 && row > Constants.BOARD_SIZE) {
            try {
                System.out.println(Constants.ASK_ROW);
                row = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(Constants.INVALID_CELL);
                scanner.next();
            }
        }
        return row;
    }

    public int getCol() {
        int col = 0;

        while (col < 1 && col > Constants.BOARD_SIZE) {
            try {
                System.out.println(Constants.ASK_COL);
                col = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(Constants.INVALID_CELL);
                scanner.next();
            }
        }
        return col;
    }

    public String getCommand() {
        String command = "";

        while (!command.equals(Constants.TOGGLE_COMMAND) || !command.equals(Constants.START_COMMAND) || !command.equals(Constants.PAUSE_COMMAND) || !command.equals(Constants.RESET_COMMAND) || !command.equals(Constants.SET_GRID_SIZE_COMMAND) || !command.equals(Constants.EXIT_COMMAND) || !command.equals(Constants.HELP_COMMAND)) {
            try {
                System.out.println(Constants.ASK_COMMAND);
                command = scanner.nextLine();
            } catch (Exception e) {
                System.out.println(Constants.INVALID_COMMAND);
                scanner.next();
            }
        }
        return command;
    }

    public String cellToString(boolean cell) {
        if (cell == Constants.ALIVE) {
            return Constants.ALIVE_CELL;
        } else {
            return Constants.DEAD_CELL;
        }
    }

    public void printBoard() {
        for (int x = 0; x < Constants.BOARD_SIZE; x++) {
            for (int y = 0; y < Constants.BOARD_SIZE; y++) {
                System.out.print(cellToString(state.getBoardCell(x,y)));
            }
            System.out.println();
        }
    }
}
