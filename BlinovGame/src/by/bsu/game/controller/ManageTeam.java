package by.bsu.game.controller;

import by.bsu.game.services.TeamEditor;
import by.bsu.game.view.ChoosePlayer;
import by.bsu.game.view.InputName;
import by.bsu.game.view.Menu;

public class ManageTeam implements Command {
    public void execute() {

        int playerNumber= ChoosePlayer.choosePlayer();
        if(playerNumber == 1){
            Menu.firstPlayer.setName(InputName.inputName());
            TeamEditor.editTeam(Menu.firstPlayer);
        }
        if(playerNumber == 2){
            Menu.secondPlayer.setName(InputName.inputName());
            TeamEditor.editTeam(Menu.secondPlayer);
        }
    }
}
