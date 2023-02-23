package structure.composites;

import model.interfaces.IMovable;

import java.util.ArrayList;

public class MovableComposite implements IComposite<IMovable>, IMovable {
    ArrayList<IMovable> components;

    public MovableComposite() {
        components = new ArrayList<>();
    }
    @Override
    public void addComponent(IMovable component) {
        components.add(component);
    }

    @Override
    public void removeComponent(IMovable component) {
        components.remove(component);
    }

    @Override
    public void move() {
        components.forEach(IMovable::move);
    }

    @Override
    public void turnLeft() {
        components.forEach(IMovable::turnLeft);
    }

    @Override
    public void turnRight() {
        components.forEach(IMovable::turnRight);
    }
}
