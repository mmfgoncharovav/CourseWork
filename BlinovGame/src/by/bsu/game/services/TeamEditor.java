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
            for (int i = 0; i < count; i++) {
                System.out.println(i + " ------- " + UnitsForSale.getInstance().getUnitList().get(i));
            }
            System.out.println("Choose the unit you want to buy, print " + count + " to exit");
            int choice = InputNumber.inputNumber(count+1);
            if(choice==count) {
                break;
            }
            Composite squad = new Composite();
            Component unitToBeAdded = UnitsForSale.getInstance().getUnitList().get(choice);
            squad.add(unitToBeAdded);
            army.add(squad);
            Unit unit = (Unit) unitToBeAdded;
            player.setGold(player.getGold()-unit.getPrice());



        }
    }

}
