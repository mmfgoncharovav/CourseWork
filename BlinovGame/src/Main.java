import entity.Component;
import entity.Composite;
import entity.Unit;

public class Main {

    public static void main(String[] args) {
       Unit unit1 = new Unit("Orc1",100,10);
       Unit unit2 = new Unit("Orc2",200,10);
       Unit dUnit1 = new Unit("Elf1",10,5);
       Unit dUnit2 = new Unit("Elf2",10,3);
       Component squad1 = new Composite();
       squad1.add(unit1);
       squad1.add(unit2);
       Component squad2 = new Composite();
       Component squad3 = new Composite();
       squad2.add(dUnit1);
       squad3.add(dUnit2);
       Component army1 = new Composite();
       army1.add(squad1);
       Component army2 = new Composite();
       army2.add(squad2);
       army2.add(squad3);
       Component megaArmy1 = new Composite();
       megaArmy1.add(army2);
       army1.attack(army2);
       System.out.println(army2);
    }
}
