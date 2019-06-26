import action.Play;
import entity.Component;
import entity.Composite;
import entity.Player;
import entity.Unit;

public class Main {

    public static void main(String[] args) {
        Unit orc1 = new Unit("Uruk",100,20,5);
        Unit orc2 = new Unit("Tarrok",250,30,5);
        Unit human1 = new Unit("Alexandr",50,10,0);
        Unit human2 = new Unit("Oleg",10,1,0);
        Composite orcSquad = new Composite();
        orcSquad.add(orc1);
        orcSquad.add(orc2);
        Composite orcArmy = new Composite();
        orcArmy.add(orcSquad);
        Composite humanSquad = new Composite();
        humanSquad.add(human1);
        humanSquad.add(human2);
        Composite humanArmy = new Composite();
        humanArmy.add(humanSquad);
        Player first = new Player("Alexandr",humanArmy);
        Player second = new Player("Egor", orcArmy);
        Play.play(first,second);

    }
}
