package entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Unit implements Component {

    private static final Logger LOGGER = LogManager.getLogger(Unit.class);
    private String name;
    private int healthPoints;
    private int attackPower;
    private boolean isDead;
    public Unit(String name,int healthPoints, int attackPower ) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.attackPower = attackPower;
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
    public void attack(Component comp) {
        Component aboveTemp = comp;
        Component component = comp;
        if (component.getChildren().isEmpty()) {
             aboveTemp = component;
            component = component.getChildren().get(0);
        }
        while (!component.getChildren().isEmpty()) {
             aboveTemp = component;
            component = component.getChildren().get(0);
        }
        Unit unit = (Unit) component;
        LOGGER.info(this + "attacks " + unit);
        unit.healthPoints = unit.healthPoints - this.attackPower;
        if (unit.healthPoints <= 0) {
            LOGGER.info(unit + " got killed ");
            aboveTemp.remove(component);
        }
    }



    public boolean isDead() {
        return isDead;
    }

    public void setDead(boolean dead) {
        isDead = dead;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Unit unit = (Unit) o;
        return healthPoints == unit.healthPoints &&
                attackPower == unit.attackPower &&
                name.equals(unit.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, healthPoints, attackPower);
    }

    @Override
    public String toString() {
        return "Unit{" +
                "name='" + name + '\'' +
                ", healthPoints=" + healthPoints +
                ", attackPower=" + attackPower +
                '}';
    }
}
