package action;

import entity.Composite;
import entity.Player;

public class Play {
    public static void play(Player firstPlayer, Player secondPlayer){
        firstPlayer.setOpponent(secondPlayer);
        secondPlayer.setOpponent(firstPlayer);
        while(!firstPlayer.getArmy().getChildren().isEmpty()
        && !secondPlayer.getArmy().getChildren().isEmpty()) {
            firstPlayer.attack(0,0);
            secondPlayer.attack(0,0);
        }
    }
}
