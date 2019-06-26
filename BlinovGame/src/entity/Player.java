package entity;

import java.util.List;

public class Player {
    private String name;
    private Composite army;
    private Player opponent;

    public Player(String name, Composite army) {
        this.name = name;
        this.army = army;
    }

    public void attack(int indexOfAttacker, int indexToBeAttacked) {
        Composite army = this.army;
        Composite opponentsArmy = opponent.army;
        Component squad = army.getChildren().get(indexOfAttacker);
        Component opponentsSquad = opponentsArmy.getChildren().get(indexToBeAttacked);
        squad.attack(opponentsSquad);
        army.clean();
        opponentsArmy.clean();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Composite getArmy() {
        return army;
    }

    public void setArmy(Composite army) {
        this.army = army;
    }

    public Player getOpponent() {
        return opponent;
    }

    public void setOpponent(Player opponent) {
        this.opponent = opponent;
    }
}
