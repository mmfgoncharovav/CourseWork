package by.bsu.game.controller;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.HashMap;
import java.util.Map;

/**
 * Class for providing commands.
 */
final class CommandProvider {
    /**
     * Logger.
     */
    private static final Logger LOGGER =
            LogManager.getLogger(CommandProvider.class);
    /**
     * Map for commands.
     */
    private final Map<CommandName, Command> repository = new HashMap<>();

    /**
     * Constructor.
     */
    CommandProvider() {
        repository.put(CommandName.PLAY,
                new Play());
        repository.put(CommandName.MANAGE_TEAM, new ManageTeam());
    }

    /**
     * Getter for command.
     * @param name command name
     * @return command
     */
    Command getCommand(final String name) {
        CommandName commandName;
        Command command = null;

        try {
            commandName = CommandName.valueOf(name.toUpperCase());
            command = repository.get(commandName);
        } catch (IllegalArgumentException | NullPointerException e) {
            LOGGER.warn("Invalid command given");
        }
        return command;
    }
}
