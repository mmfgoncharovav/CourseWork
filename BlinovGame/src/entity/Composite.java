package entity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Composite implements Component {
    private List<Component> components;
    public Composite() {
        components = new ArrayList<>();
    }
    public void add(Component component){
        components.add(component);
    }
    public List<Component> getChildren(){
        return components;
    }
    public void attack(Component component) {
        for (Component comp:components) {
            comp.attack(component);
        }
    }
//    public void attack(Component component) {
//        ArrayList<Unit> attackingSquad = new ArrayList<>();
//        ArrayList<Unit> defendingSquad = new ArrayList<>();
//        for (Component comp:components ) {
//            attackingSquad.add((Unit)comp);
//        }
//        for( Component comp:component.getChildren()) {
//            defendingSquad.add((Unit)comp);
//        }
//        for (Unit unit:attackingSquad) {
//            unit.attack(defendingSquad.get(0));
//            if(defendingSquad.get(0).getHealthPoints()<=0) {
//                component.remove((Component)defendingSquad.get(0));
//                defendingSquad.remove(0);
//            }
//        }
//    }
    public void remove(Component component) {
        this.components.remove(component);
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Composite composite = (Composite) o;
        return Objects.equals(components, composite.components);
    }

    @Override
    public int hashCode() {
        return Objects.hash(components);
    }

    @Override
    public String toString() {
        return components.toString();
    }
}
