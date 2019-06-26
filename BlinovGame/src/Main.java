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
        Unit undead1 = new Unit("Undead",999,10,0);
        Unit undead2 = new Unit("Valera",500,20,0);
        Unit elf1 = new Unit("Dobel",200,20,10);
        Unit elf2 = new Unit("Elza",400,50,20);


        Composite elfSquad = new Composite();
        elfSquad.add(elf1);
        elfSquad.add(elf2);
        Composite humanSquad = new Composite();
        humanSquad.add(human1);
        humanSquad.add(human2);
        Composite orcSquad = new Composite();
        orcSquad.add(orc1);
        orcSquad.add(orc2);
        Composite undeadSquad = new Composite();
        undeadSquad.add(undead1);
        undeadSquad.add(undead2);

        Composite firstArmy = new Composite();
        firstArmy.add(elfSquad);
        firstArmy.add(humanSquad);

        Composite secondArmy = new Composite();
        secondArmy.add(orcSquad);
        secondArmy.add(undeadSquad);

        Player first = new Player("Alexandr", firstArmy);
        Player second = new Player("Egor", secondArmy);
        Play.play(first,second);

    }
}
