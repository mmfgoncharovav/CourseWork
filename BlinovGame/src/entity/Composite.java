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
            component.clean();
            comp.attack(component);
        }
    }
    public void remove(Component component) {
        this.components.remove(component);
    }
    public void clean() {
        for (Component comp:
             components) {
            if(comp.getChildren().isEmpty()) {
                components.remove(comp);
            }

        }
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
