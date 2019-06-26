package action;

import entity.Composite;
import entity.Player;
import view.InputNumber;
import view.PrintArmy;

public class Play {
    public static void play(Player firstPlayer, Player secondPlayer){
        firstPlayer.setOpponent(secondPlayer);
        secondPlayer.setOpponent(firstPlayer);
        while(!firstPlayer.getArmy().getChildren().isEmpty()
        && !secondPlayer.getArmy().getChildren().isEmpty()) {
            System.out.println("First player move: \n");
            PrintArmy.printArmy(firstPlayer.getArmy());
            int indexOfAttacker = InputNumber.inputNumber();
            PrintArmy.printArmy(secondPlayer.getArmy());
            int indexToBeAttacked = InputNumber.inputNumber();
            firstPlayer.attack(indexOfAttacker,indexToBeAttacked);
            PrintArmy.printArmy(secondPlayer.getArmy());
            indexOfAttacker = InputNumber.inputNumber();
            PrintArmy.printArmy(firstPlayer.getArmy());
            indexToBeAttacked = InputNumber.inputNumber();
            secondPlayer.attack(indexOfAttacker,indexToBeAttacked);
        }
        if(firstPlayer.getArmy().getChildren().isEmpty()) {
            System.out.println("Player " + secondPlayer.getName() + " won");
        } else {
            System.out.println("Player " + firstPlayer.getName() + " won");
        }
    }
}
