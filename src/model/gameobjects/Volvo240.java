package model.gameobjects;

import model.Motorized;
import model.interfaces.IMotorized;

import java.awt.*;

public class Volvo240 implements IMotorized {

    private final static double trimFactor = 1.25;

    private Motorized motorized;

    /**
     * constructor for Models.Volvo240 using the superclass in the car.java file. Color can be specified here
     *
     * @param color
     */
    public Volvo240(Color color) {
        motorized = new Motorized("Volvo240", color, 4, Size.MEDIUM, 100);
    }
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    public double getEnginePower() {
        return motorized.getEnginePower();
    }

    @Override
    public void startEngine() {
        motorized.startEngine();
    }

    @Override
    public void stopEngine() {
        motorized.stopEngine();
    }

    @Override
    public int getNrDoors() {
        return motorized.getNrDoors();
    }

    @Override
    public void incrementSpeed(double amount, double speedFactor) {
        motorized.incrementSpeed(amount, speedFactor);
    }

    @Override
    public void decrementSpeed(double amount, double speedFactor) {
        motorized.decrementSpeed(amount, speedFactor);
    }

    @Override
    public void move() {
        motorized.move();
    }

    @Override
    public void turnLeft() {
        motorized.turnLeft();
    }

    @Override
    public void turnRight() {
        motorized.turnRight();
    }

    @Override
    public String getModelName() {
        return motorized.getModelName();
    }

    @Override
    public double getCurrentSpeed() {
        return motorized.getCurrentSpeed();
    }

    @Override
    public void setCurrentSpeed(double currentSpeed) {
        motorized.setCurrentSpeed(currentSpeed);
    }

    @Override
    public Color getColor() {
        return motorized.getColor();
    }

    @Override
    public void setColor(Color clr) {
        motorized.setColor(clr);
    }

    @Override
    public double getX() {
        return motorized.getX();
    }

    @Override
    public void setX(double x) {
        motorized.setX(x);
    }

    @Override
    public double getY() {
        return motorized.getY();
    }

    @Override
    public void setY(double y) {
        motorized.setY(y);
    }

    @Override
    public Dir getCurDir() {
        return motorized.getCurDir();
    }

    @Override
    public void setCurDir(Dir curDir) {
        motorized.setCurDir(curDir);
    }

    @Override
    public void gas(double amount, double speedFactor) {
        motorized.gas(amount, speedFactor);
    }

    @Override
    public void brake(double amount, double speedFactor) {
        motorized.brake(amount, speedFactor);
    }
}