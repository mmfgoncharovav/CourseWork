package by.bsu.game.services;

import by.bsu.game.entity.*;
import by.bsu.game.view.InputNumber;

public class TeamEditor {
    public static void editTeam(Player player) {
        Composite army = new Composite();
        player.setArmy(army);
        int count = UnitsForSale.getInstance().getUnitList().size();
        while(true) {
            System.out.println(player.getName()+ " " + player.getGold());
            System.out.println("Current army: ");
            for(int i = 0 ; i < army.getChildren().size(); i++) {
                System.out.println(army.getChildren().get(i));
            }
            System.out.println("Unit offers: ");
            for (int i = 0; i < count; i++) {
                System.out.println(i + " ------- " + UnitsForSale.getInstance().getUnitList().get(i));
            }
            System.out.println("Choose the unit you want to buy, print " + count + " to exit");
            int choice = InputNumber.inputNumber(count+1);
            if(choice==count) {
                break;
            }
            Component unitToBeAdded = UnitsForSale.getInstance().getUnitList().get(choice);
            Unit unit = (Unit) unitToBeAdded;
            if(player.getGold()-unit.getPrice()>=0) {
                boolean isAdded = false;
                for (Component comp:
                     army.getChildren()) {
                    Unit toBeCompared = (Unit) comp.getChildren().get(0);
                    if (unit.getUnitType() == toBeCompared.getUnitType()) {
                        comp.add(unit);
                        isAdded = true;
                    }
                }
                if(isAdded == false) {
                    Composite squad = new Composite();
                    squad.add(unit);
                    army.add(squad);
                }
                player.setGold(player.getGold() - unit.getPrice());
            } else {
                System.out.println("You are out of gold!");
            }



        }
    }

}
