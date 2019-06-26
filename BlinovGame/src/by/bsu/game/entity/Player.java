package by.bsu.game.entity;

public class Player {
    private static final int DEFAULT_GOLD = 1000;
    private String name;
    private Composite army;
    private int gold;
    private Player opponent;

    public Player(String name, Composite army) {
        this.name = name;
        this.army = army;
    }

    public Player() {
        this.gold = DEFAULT_GOLD;
    }

    public Player(String name, Composite army, int gold) {
        this.name = name;
        this.army = army;
        this.gold = gold;
    }

    public void attack(int indexOfAttacker, int indexToBeAttacked) {
        Composite army = this.army;
        Composite opponentsArmy = opponent.army;
        Component squad = army.getChildren().get(indexOfAttacker);
        Component opponentsSquad = opponentsArmy.getChildren().get(indexToBeAttacked);
        squad.attack(opponentsSquad);
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

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
