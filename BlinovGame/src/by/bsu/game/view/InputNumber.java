package by.bsu.game.view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputNumber {
    public static int inputNumber(int n) {
        System.out.println("\nChoose number");
        Scanner scanner = new Scanner(System.in);
        try {
            int result = scanner.nextInt();
            return (result<n && result>=0) ?  result : inputNumber(n);
        } catch (InputMismatchException ex) {
            System.out.println("Enter correct value please.");
            return inputNumber(n);
        }
    }
}
