package model;

import model.interfaces.IMotorized;

import java.awt.*;

public class Motorized implements IMotorized {
    private final Vehicle vehicle;
    private final double enginePower; // Engine power of the car
    private boolean engineState; // Engine power of the car

    /**
     * Superclass Motorized
     * @param modelName Name of motorized thing
     * @param color Color of motorized thing
     * @param enginePower Engine power of motorized thing
     */
    public Motorized(String modelName, Color color, int nrDoors, Size size, double enginePower) {
        vehicle = new Vehicle(modelName, color, nrDoors, size);
        this.enginePower = enginePower;
        stopEngine();
    }

    /**
     * Getter for engine power
     * @return
     */
    @Override
    public double getEnginePower() {
        return enginePower;
    }


    /**
     * Turns engine on
     */
    @Override
    public void startEngine() {
        engineState = true;
    }

    /**
     * Turns engine off and sets speed to 0
     */
    @Override
    public void stopEngine() {
        engineState = false;
        setCurrentSpeed(0);
    }

    @Override
    public int getNrDoors() {
        return vehicle.getNrDoors();
    }

    @Override
    public double speedFactor() {
        return vehicle.speedFactor();
    }

    /**
     * If engine is on, increases currentSpeed variable
     * @param amount
     */
    @Override
    public void incrementSpeed(double amount, double speedFactor) {
        double speed = Math.min(getCurrentSpeed() + speedFactor * amount, getEnginePower());
        if (speed > getCurrentSpeed()) {
            setCurrentSpeed(speed);
        }
    }

    /**
     * Decreasing currentSpeed variable
     * @param amount
     */
    @Override
    public void decrementSpeed(double amount, double speedFactor) {
        vehicle.decrementSpeed(amount, speedFactor);
    }

    @Override
    public void move() {
        vehicle.move();
    }

    @Override
    public void turnLeft() {
        vehicle.turnLeft();
    }

    @Override
    public void turnRight() {
        vehicle.turnRight();
    }

    @Override
    public String getModelName() {
        return vehicle.getModelName();
    }

    @Override
    public double getCurrentSpeed() {
        return vehicle.getCurrentSpeed();
    }

    @Override
    public void setCurrentSpeed(double currentSpeed) {
        vehicle.setCurrentSpeed(currentSpeed);
    }

    @Override
    public Color getColor() {
        return vehicle.getColor();
    }

    @Override
    public void setColor(Color clr) {
        vehicle.setColor(clr);
    }

    @Override
    public double getX() {
        return vehicle.getX();
    }

    @Override
    public void setX(double x) {
        vehicle.setX(x);
    }

    @Override
    public double getY() {
        return vehicle.getY();
    }

    @Override
    public void setY(double y) {
        vehicle.setY(y);
    }

    @Override
    public Dir getCurDir() {
        return vehicle.getCurDir();
    }

    @Override
    public void setCurDir(Dir curDir) {
        vehicle.setCurDir(curDir);
    }

    @Override
    public void gas(double amount, double speedFactor) {
        if (engineState) {
            incrementSpeed(amount, speedFactor);
        }
    }

    @Override
    public void brake(double amount, double speedFactor) {
        vehicle.brake(amount, speedFactor);
    }
}
