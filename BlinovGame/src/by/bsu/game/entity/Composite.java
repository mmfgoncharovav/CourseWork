package by.bsu.game.entity;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Composite implements Component {
    private static final Logger LOGGER = LogManager.getLogger(Composite.class);
    private List<Component> components;
    public Composite() {
        components = new ArrayList<>();
    }
    public void add(final Component component) {
        components.add(component);
    }
    public List<Component> getChildren() {
        return components;
    }
    public void attack(Component component) {
        for (Component comp : components) {
            if (!component.getChildren().isEmpty()
                    && component.getClass() != Unit.class) {
                component.clean();
            }
                comp.attack(component);
            }
        component.clean();
        }
    public void remove(final Component component) {
        this.components.remove(component);
    }
    public void clean() {
        for (int i = 0; i < components.size(); i++) {
            if (components.get(i).getChildren().isEmpty()
                    && components.get(i).getClass() != Unit.class) {
                components.remove(components.get(i));
            } else {
                components.get(i).clean();
            }
        }
    }
    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
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
