package view;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InputNumber {
    public static int inputNumber() {
        System.out.println("\nChoose the number of squad");
        Scanner scanner = new Scanner(System.in);
        try {
            return scanner.nextInt();
        } catch (InputMismatchException ex) {
            System.out.println("Enter correct value please.");
            return inputNumber();
        }
    }
}
