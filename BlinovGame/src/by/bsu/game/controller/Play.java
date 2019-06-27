package by.bsu.game.controller;

import by.bsu.game.services.PlayRunner;
import by.bsu.game.view.Menu;

public class Play implements Command {
    public void execute() {
        PlayRunner.play(Menu.FIRST_PLAYER, Menu.SECOND_PLAYER);
    }
}
