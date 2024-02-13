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

        while (row < 1 || row > Constants.BOARD_SIZE) {
            try {
                System.out.println(Constants.ASK_ROW);
                row = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(Constants.INVALID_CELL);
                scanner.next();
            }
        }
        return row-1;
    }

    public int getCol() {
        int col = 0;

        while (col < 1 || col > Constants.BOARD_SIZE) {
            try {
                System.out.println(Constants.ASK_COL);
                col = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(Constants.INVALID_CELL);
                scanner.next();
            }
        }
        return col-1;
    }

    public int getSteps() {
        int steps = 0;

        while (steps < 1 || steps > Constants.MAX_STEPS) {
            try {
                System.out.println(Constants.ASK_STEPS);
                steps = scanner.nextInt();
            } catch (Exception e) {
                System.out.println(Constants.INVALID_STEPS);
                scanner.next();
            }
        }
        return steps;
    }

    public String getCommand() {
        String command = "";

        while (!state.isValidCommand(command)) {
            try {
                System.out.println(Constants.ASK_COMMAND);
                command = scanner.nextLine();
            } catch (Exception e) {
                System.out.println(Constants.INVALID_COMMAND);
                scanner.next();
            }
            if (!state.isValidCommand(command)) {
                System.out.println(Constants.INVALID_COMMAND);
            }
        }
        return command;
    }

    public String cellToString(int cell) {
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
        for (int y = 0; y < Constants.BOARD_SIZE; y++) {

            System.out.print(Constants.SEPERATION_BAR);
        }
        System.out.println();
    }
}
