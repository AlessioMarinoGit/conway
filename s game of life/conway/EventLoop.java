package conway;

/**
 * Write a description of class EventLoop here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
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
                while (steps > 0) {
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
