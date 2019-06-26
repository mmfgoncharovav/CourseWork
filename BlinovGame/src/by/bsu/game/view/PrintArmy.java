package by.bsu.game.view;

import by.bsu.game.entity.Composite;

public class PrintArmy {
    public static void printArmy(Composite composite) {
        for(int i = 0 ; i < composite.getChildren().size(); i++) {
            System.out.println(i +" -------- "+ composite.getChildren().get(i).toString());
        }
    }
}
