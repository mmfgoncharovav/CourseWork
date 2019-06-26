package entity;

import java.util.List;

public interface Component  {
    void add(Component component);
    List<Component> getChildren();
    void remove(Component component);
    void attack(Component component);
}
