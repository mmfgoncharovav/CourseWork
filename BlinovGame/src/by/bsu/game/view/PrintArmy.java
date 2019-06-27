package by.bsu.game.view;

import by.bsu.game.entity.Composite;

public final class PrintArmy {
    private PrintArmy() { }
    public static void printArmy(final Composite composite) {
        for (int i = 0; i < composite.getChildren().size(); i++) {
            System.out.println(i + " -------- " + composite.getChildren().
                    get(i).toString());
        }
    }
}
