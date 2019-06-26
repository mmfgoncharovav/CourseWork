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

    public Unit(String name, int healthPoints, int attackPower, int defence ) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.attackPower = attackPower;
        this.defence = defence;
    }

    public Unit(String name, int healthPoints, int attackPower, int defence, int price) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.attackPower = attackPower;
        this.defence = defence;
        this.price = price;
    }

    public Unit clone() {
        Unit unit;
        try {
            unit =(Unit) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException();
        }
        return unit;
    }
    public void add(Component component) {
    }
    public List<Component> getChildren() {
        return new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttackPower() {
        return attackPower;
    }

    public void setAttackPower(int attackPower) {
        this.attackPower = attackPower;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }
    public void remove(Component component) { }
    public void clean() { }
    public void attack(Component comp) {
        Component aboveTemp = comp;
        Component component = comp;
        while (!component.getChildren().isEmpty()&&component.getClass()!=Unit.class) {
            aboveTemp = component;
            component = component.getChildren().get(0);
        }
        if(component.getClass()==Unit.class) {
            Unit unit = (Unit) component;
            LOGGER.info(this + "attacks " + unit);
            int damage = this.attackPower - unit.defence;
            if (damage < 0) {
                damage = 0;
            }
            unit.healthPoints = unit.healthPoints - damage;
            if (unit.healthPoints <= 0) {
                LOGGER.info(unit + " got killed ");
                aboveTemp.remove(component);
                aboveTemp.clean();
            }
        }
    }

    public int getDefence() {
        return defence;
    }

    public void setDefence(int defence) {
        this.defence = defence;
    }


    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return healthPoints == unit.healthPoints &&
                attackPower == unit.attackPower &&
                defence == unit.defence &&
                name.equals(unit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, healthPoints, attackPower, defence);
    }

    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", healthPoints=" + healthPoints +
                ", attackPower=" + attackPower +
                ", defence=" + defence +
                ", price=" + price +
                '}';
    }
}
