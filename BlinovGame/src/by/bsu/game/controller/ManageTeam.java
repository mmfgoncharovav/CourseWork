package by.bsu.game.controller;

import by.bsu.game.services.TeamEditor;
import by.bsu.game.view.ChoosePlayer;
import by.bsu.game.view.InputName;
import by.bsu.game.view.Menu;

public class ManageTeam implements Command {
    public void execute() {

        int playerNumber = ChoosePlayer.choosePlayer();
        if (playerNumber == 1) {
            Menu.FIRST_PLAYER.setName(InputName.inputName());
            TeamEditor.editTeam(Menu.FIRST_PLAYER);
        }
        if (playerNumber == 2) {
            Menu.SECOND_PLAYER.setName(InputName.inputName());
            TeamEditor.editTeam(Menu.SECOND_PLAYER);
        }
    }
}
