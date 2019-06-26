package by.bsu.game.entity;

import java.util.ArrayList;
import java.util.List;

public class UnitsForSale {
    private List<Component> unitList;


    private static final UnitsForSale INSTANCE = new UnitsForSale();

    public static UnitsForSale getInstance() {
        return INSTANCE;
    }

    private UnitsForSale() {
        this.unitList = new ArrayList<>();
    }

    public List<Component> getUnitList() {
        return unitList;
    }

    public void setUnitList(List<Component> unitList) {
        this.unitList = unitList;
    }
}
