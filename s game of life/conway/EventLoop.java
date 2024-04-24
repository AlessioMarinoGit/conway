package conway;

// The foundation for the main functions for this code were given to me by my teacher.

public class EventLoop
{
    State state = new State();
    UI ui = new UI();

    int row, col;
    int steps = 0;

    public static void main(String[] args) {
        EventLoop eventLoop = new EventLoop();
        eventLoop.run();
    }

    public void runCommand(String command) {
        state.setGameState(Constants.RUN_COMMAND);
        if (command.equals(Constants.TOGGLE_COMMAND)) {
            row = ui.getRow();
            col = ui.getCol();

            state.toggleCommand(row, col);

            ui.printBoard();
            state.setGameState(Constants.GET_COMMAND);
        } else if (command.equals(Constants.START_COMMAND)) {
            steps = ui.getSteps();

            state.setGameState(Constants.RUN);
        } else if (command.equals(Constants.HELP_COMMAND)) {
            System.out.println(Constants.COMMANDS);

            state.setGameState(Constants.GET_COMMAND);
        } else if (command.equals(Constants.RESET_COMMAND)) {
            state.clearBoard();

            ui.printBoard();
            state.setGameState(Constants.GET_COMMAND);
        } else if (command.equals(Constants.SET_GRID_SIZE_COMMAND)) {
            state.setBoardSize(ui.getBoardSize());
            
            ui.printBoard();
            state.setGameState(Constants.GET_COMMAND);
        } else if (command.equals(Constants.EXIT_COMMAND)) {
            System.out.println(Constants.GOODBYE_MESSAGE);
            state.setGameState(Constants.QUIT_PROGRAM);
        }
    }

    public void run() {
        while (state.getGameState() != Constants.QUIT_PROGRAM) {
            int gameState = state.getGameState();
            if (gameState == Constants.STANDBY) {
                ui.printBoard();
                state.setGameState(Constants.GET_COMMAND);
            } else if (gameState == Constants.GET_COMMAND) {
                this.runCommand(ui.getCommand());
            } else if (gameState == Constants.RUN) {
                while (steps > 0 && state.getGameState() == Constants.RUN) {
                    steps--;
                    state.Step();
                    ui.printBoard();
                    try
                    {
                        Thread.sleep(Constants.DELAY);
                    }
                    catch (InterruptedException ie)
                    {
                        ie.printStackTrace();
                    }
                }
                state.setGameState(Constants.STANDBY);
            }
        }
    }
}
