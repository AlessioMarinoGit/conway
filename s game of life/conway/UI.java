package conway;
import java.util.Scanner;

public class UI
{
    Scanner scanner;
    
    public UI() {
        scanner = new Scanner(System.in);
    }
    
    public String getCommand() {
        String command = "";
        
        while (!command.equals(Constants.TOGGLE_COMMAND) || !command.equals(Constants.START_COMMAND) || !command.equals(Constants.PAUSE_COMMAND) || !command.equals(Constants.RESET_COMMAND) || !command.equals(Constants.SET_GRID_SIZE_COMMAND) || !command.equals(Constants.EXIT_COMMAND) || !command.equals(Constants.HELP_COMMAND)) {
            try {
                System.out.println(Constants.GET_COMMAND);
                command = scanner.nextLine();
            } catch (Exception e) {
                System.out.println(Constants.INVALID_COMMAND);
                scanner.next();
            }
        }
        return command;
    }
}
