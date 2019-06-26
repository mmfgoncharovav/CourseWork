package by.bsu.game.view;

import java.util.Scanner;

public class InputName {
    public static String inputName() {
        System.out.println("Input player's name");
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
