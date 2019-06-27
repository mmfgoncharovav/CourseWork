package by.bsu.game.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Unit implements Component, Cloneable {

    private static final Logger LOGGER = LogManager.getLogger(Unit.class);
    private String name;
    private int healthPoints;
    private int attackPower;
    private int defence;
    private int price;
    private UnitType unitType;

    public Unit(final String newName, final int newHealthPoints,
                final int newAttackPower, final int newDefence) {
        this.name = newName;
        this.healthPoints = newHealthPoints;
        this.attackPower = newAttackPower;
        this.defence = newDefence;
    }

    public Unit(final String newName, final int newHealthPoints,
                final int newAttackPower, final int newDefence,
                final int newPrice, final UnitType newUnitType) {
        this.name = newName;
        this.healthPoints = newHealthPoints;
        this.attackPower = newAttackPower;
        this.defence = newDefence;
        this.price = newPrice;
        this.unitType = newUnitType;
    }


    public Unit clone() {
        Unit unit;
        try {
            unit = (Unit) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException();
        }
        return unit;
    }
    public void add(final Component component) {
    }
    public List<Component> getChildren() {
        return new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(final String newName) {
        this.name = newName;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(final int newAttackPower) {
        this.attackPower = newAttackPower;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(final int newHealthPoints) {
        this.healthPoints = newHealthPoints;
    }
    public void remove(final Component component) { }
    public void clean() { }
    public void attack(final Component comp) {
        Component aboveTemp = comp;
        Component component = comp;
        while (!component.getChildren().isEmpty()
                && component.getClass() != Unit.class) {
            aboveTemp = component;
            component = component.getChildren().get(0);
        }
        if (component.getClass() == Unit.class) {
            Unit unit = (Unit) component;
            System.out.println(this + "attacks " + unit);
            LOGGER.info(this + "attacks " + unit);
            int damage = this.attackPower - unit.defence;
            if (damage < 0) {
                damage = 0;
            }
            unit.healthPoints = unit.healthPoints - damage;
            if (unit.healthPoints <= 0) {
                System.out.println(unit + " got killed by " + this);
                LOGGER.info(unit + " got killed by " + this);
                aboveTemp.remove(component);
                aboveTemp.clean();
            }
        }
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(final int newDefence) {
        this.defence = newDefence;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(final int newPrice) {
        this.price = newPrice;
    }



    public UnitType getUnitType() {
        return unitType;
    }

    public void setUnitType(final UnitType newUnitType) {
        this.unitType = newUnitType;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Unit unit = (Unit) o;
        return healthPoints == unit.healthPoints
               && attackPower == unit.attackPower
               && defence == unit.defence
               && name.equals(unit.name)
               && unitType == unit.unitType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, healthPoints, attackPower, defence, unitType);
    }

    @Override
    public String toString() {
        return "Unit{"
                + "name='" + name + '\''
                + ", healthPoints=" + healthPoints
                + ", attackPower=" + attackPower
                + ", defence=" + defence
                + ", price=" + price
                +  ", unitType=" + unitType
                + '}';
    }
}
