package model.gameobjects;

import model.Motorized;
import model.interfaces.IMotorized;
import model.interfaces.IPlatForm;
import model.interfaces.IVehicle;

import java.awt.*;

public class Scania implements IMotorized, IPlatForm {

    private final static double trimFactor = 1;

    private int platformStage;

    private Motorized motorized;

    /**
     * Superclass for Scania
     *
     * @param color is the color of scania
     */
    public Scania(Color color) {
        motorized = new Motorized("Scania", color, 2, IVehicle.Size.MEDIUM, 90);
        platformStage = 0;
    }

    /**
     * How fast the truck can accelerate
     */
    @Override
    public double speedFactor() {
        if (getPlatStage() == 0) {
            return getEnginePower() * 0.01 * trimFactor;
        } else {
            return 0;
        }
    }

    /**
     * Getter for platform stage (how open the door is)
     *
     * @return
     */
    @Override
    public int getPlatStage() {
        return platformStage;
    }

    /**
     * Setter for platformstage
     * Checks if platformstage is between 0 and 70 degrees
     *
     * @param degree
     */
    @Override
    public void setPlatStage(int degree) {
        if (getCurrentSpeed() == 0) {
            if (degree >= 0 && degree <= 70) {
                platformStage = degree;
            } else {
                throw new RuntimeException("This platforms range is between 0-70 degrees!");
            }
        } else {
            throw new RuntimeException("Vehicle must be still too change platform stage!");
        }
    }

    /**
     * Checks if door is open
     * Unable to gas if door is open (!= 0)
     *
     * @param amount
     */
    @Override
    public void gas(double amount, double speedFactor) {
        if (getPlatStage() != 0) {
            throw new RuntimeException("This vehicle cannot move if its platform is at more than 0 degrees!");
        } else {
            motorized.gas(amount, speedFactor);
        }
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
    public IVehicle.Dir getCurDir() {
        return motorized.getCurDir();
    }

    @Override
    public void setCurDir(IVehicle.Dir curDir) {
        motorized.setCurDir(curDir);
    }

    @Override
    public void brake(double amount, double speedFactor) {
        motorized.brake(amount, speedFactor);
    }
}