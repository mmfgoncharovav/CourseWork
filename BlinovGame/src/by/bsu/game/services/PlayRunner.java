package by.bsu.game.services;

import by.bsu.game.entity.Player;
import by.bsu.game.view.InputNumber;
import by.bsu.game.view.PrintArmy;

public final class PlayRunner {
    private PlayRunner() { }
    public static void play(final Player firstPlayer,
                            final Player secondPlayer) {
        firstPlayer.setOpponent(secondPlayer);
        secondPlayer.setOpponent(firstPlayer);
        while (!firstPlayer.getArmy().getChildren().isEmpty()
        && !secondPlayer.getArmy().getChildren().isEmpty()) {

            System.out.println("\nFirst player move: \n");
            PrintArmy.printArmy(firstPlayer.getArmy());
            int indexOfAttacker = InputNumber.
                    inputNumber(firstPlayer.getArmy().getChildren().size());
            PrintArmy.printArmy(secondPlayer.getArmy());
            int indexToBeAttacked = InputNumber.
                    inputNumber(secondPlayer.getArmy().getChildren().size());
            firstPlayer.attack(indexOfAttacker, indexToBeAttacked);

            if (!secondPlayer.getArmy().getChildren().isEmpty()) {
                System.out.println("\nSecond player move: \n");
                PrintArmy.printArmy(secondPlayer.getArmy());
                indexOfAttacker = InputNumber.
                        inputNumber(secondPlayer.getArmy().getChildren().
                                size());
                PrintArmy.printArmy(firstPlayer.getArmy());
                indexToBeAttacked = InputNumber.
                        inputNumber(firstPlayer.getArmy().getChildren().size());
                secondPlayer.attack(indexOfAttacker, indexToBeAttacked);
            }
        }
        if (firstPlayer.getArmy().getChildren().isEmpty()) {
            System.out.println("Player " + secondPlayer.getName() + " won");
        } else {
            System.out.println("Player " + firstPlayer.getName() + " won");
        }
    }
}
