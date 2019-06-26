package by.bsu.game.view;

import by.bsu.game.controller.CommandName;
import by.bsu.game.controller.Controller;
import by.bsu.game.entity.Composite;
import by.bsu.game.entity.Player;

import java.util.Scanner;

public class Menu {
    public static Player firstPlayer = new Player();
    public static Player secondPlayer = new Player();
    public static void giveMenu() {
        Controller controller = new Controller();
        try(Scanner scanner = new Scanner(System.in)) {
        while (true) {
            System.out.println("Choose what do you want to do: ");
            System.out.println("1.Manage teams");
            System.out.println("2.Play");
            System.out.println("3.Quit");
            int choice = InputNumber.inputNumber(4);
            if(choice == 3) {
                break;
            }
            switch (choice) {
                case 1:
                    controller.executeTask(CommandName.MANAGE_TEAM.toString());
                    break;
                case 2:
                    controller.executeTask(CommandName.PLAY.toString());
                    break;
                default:
            }
        }
        }

    }
}
