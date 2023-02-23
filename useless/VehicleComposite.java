package structure.observer.composites;

import model.interfaces.IMovable;
import model.interfaces.IVehicle;

import java.awt.*;
import java.util.ArrayList;

public class VehicleComposite implements IComposite<IVehicle>, IVehicle {
    ArrayList<IVehicle> components;

    public VehicleComposite() {
        components = new ArrayList<>();
    }
    @Override
    public void addComponent(IVehicle component) {
        components.add(component);
    }

    @Override
    public void removeComponent(IVehicle component) {
        components.remove(component);
    }

    @Override
    public void gas(double amount, double speedFactor) {
        components.forEach(component -> component.gas(amount, speedFactor));
    }

    @Override
    public void brake(double amount, double speedFactor) {
        components.forEach(component -> component.brake(amount, speedFactor));
    }

    @Override
    public int getNrDoors() {
        throw new UnsupportedOperationException();
    }

    @Override
    public double speedFactor() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void incrementSpeed(double amount, double speedFactor) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void decrementSpeed(double amount, double speedFactor) {
        throw new UnsupportedOperationException();
    }

    @Override
    public String getModelName() {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getCurrentSpeed() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setCurrentSpeed(double currentSpeed) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Color getColor() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setColor(Color clr) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getX() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setX(double x) {
        throw new UnsupportedOperationException();
    }

    @Override
    public double getY() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setY(double y) {
        throw new UnsupportedOperationException();
    }

    @Override
    public Dir getCurDir() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void setCurDir(Dir curDir) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void move() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void turnLeft() {
        throw new UnsupportedOperationException();
    }

    @Override
    public void turnRight() {
        throw new UnsupportedOperationException();
    }
}
