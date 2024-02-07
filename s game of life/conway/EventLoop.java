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

    public static void main(String[] args) {
        EventLoop eventLoop = new EventLoop();
        eventLoop.run();
    }
    
    public void runCommand(String command) {
        if (command.equals(Constants.TOGGLE_COMMAND)) {
            state.toggleCommand(ui.getRow(), ui.getCol());
        }
    }

    public void run() {
        while (state.getGameState() != Constants.QUIT_PROGRAM) {
            int gameState = state.getGameState();
            if (gameState == Constants.STANDBY) {
                state.setGameState(Constants.GET_COMMAND);
            } else if (gameState == Constants.GET_COMMAND) {
                state.runCommand(ui.getCommand());
            }
        }
    }
}
