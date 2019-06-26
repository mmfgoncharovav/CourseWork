package by.bsu.game.controller;

/**
 * Controller class.
 */
public class Controller {
    /**
     * Command provider.
     */
    private final CommandProvider provider = new CommandProvider();


    /**
     * Execution method.
     * @param request request
     */
    public void executeTask(final String request) {
        String commandName;
        Command executionCommand;
        commandName = request;
        executionCommand = provider.getCommand(commandName);
        executionCommand.execute();
    }
}
