package by.bsu.game.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class ChoosePlayer {
    public static int choosePlayer() {
            System.out.println("\n Choose a player to edit: ");
            System.out.println("1: First player ");
            System.out.println("2: Second player ");
            Scanner scanner = new Scanner(System.in);
            try {
                int result = scanner.nextInt();
                return (result <= 2 && result > 0) ?  result : choosePlayer();
            } catch (InputMismatchException ex) {
                System.out.println("Enter correct value please.");
                return choosePlayer();
            }
        }
}
