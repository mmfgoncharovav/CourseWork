package by.bsu.game.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public final class InputNumber {
    private InputNumber() { }
    public static int inputNumber(final int n) {
        System.out.println("\nChoose number");
        Scanner scanner = new Scanner(System.in);
        try {
            int result = scanner.nextInt();
            return (result < n && result >= 0) ?  result : inputNumber(n);
        } catch (InputMismatchException ex) {
            System.out.println("Enter correct value please.");
            return inputNumber(n);
        }
    }
}
