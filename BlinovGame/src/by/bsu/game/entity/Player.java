package by.bsu.game.entity;

public class Player {
    private static final int DEFAULT_GOLD = 1000;
    private String name;
    private Composite army;
    private int gold;
    private Player opponent;

    public Player(final String newName, final Composite newArmy) {
        this.name = newName;
        this.army = newArmy;
    }

    public Player() {
        this.gold = DEFAULT_GOLD;
    }

    public Player(final String newName,
                  final Composite newArmy, final int newGold) {
        this.name = newName;
        this.army = newArmy;
        this.gold = newGold;
    }

    public void attack(final int indexOfAttacker, final int indexToBeAttacked) {
        Composite attackingArmy = this.army;
        Composite opponentsArmy = opponent.army;
        Component squad = attackingArmy.getChildren().get(indexOfAttacker);
        Component opponentsSquad
                = opponentsArmy.getChildren().get(indexToBeAttacked);
        squad.attack(opponentsSquad);
        opponentsArmy.clean();
    }

    public String getName() {
        return name;
    }

    public void setName(final String newName) {
        this.name = newName;
    }

    public Composite getArmy() {
        return army;
    }

    public void setArmy(final Composite newArmy) {
        this.army = newArmy;
    }

    public Player getOpponent() {
        return opponent;
    }

    public void setOpponent(final Player newOpponent) {
        this.opponent = newOpponent;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(final int newGold) {
        this.gold = newGold;
    }
}
