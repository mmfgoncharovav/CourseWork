package by.bsu.game;

import by.bsu.game.entity.*;
import by.bsu.game.view.Menu;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        Unit orc = new Unit("Uruk",100,20,5,100,UnitType.ORC);
        Unit human = new Unit("Alexandr",50,10,0,50,UnitType.HUMAN);
        Unit undead = new Unit("Undead",999,10,0,250,UnitType.UNDEAD);
        Unit elf= new Unit("Dobel",200,20,10,200,UnitType.ELF);
        List<Component> units = List.of(orc,human,undead,elf);
        UnitsForSale.getInstance().setUnitList(units);
        Menu.giveMenu();
    }
}
