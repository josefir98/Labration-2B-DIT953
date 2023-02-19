package model.gameobjects;

import model.Motorized;
import model.interfaces.IMotorized;
import model.interfaces.IPlatForm;
import model.Storage;

import java.awt.*;

public class CarCarrierScania implements IMotorized, IPlatForm {
    private final static double trimFactor = 1.1;
    private Storage<IMotorized, CarCarrierScania> carsStored = new Storage();
    private int platformStage;

    private Motorized motorized;

    /**
     * Superclass for CarCarrierScania
     *
     * @param color is the color of the car carier
     */
    public CarCarrierScania(Color color) {
        motorized = new Motorized("CarCarrierScania", color, 2, Size.MEDIUM, 95);
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
     * Getter for PlatformStage
     *
     * @return
     */
    @Override
    public int getPlatStage() {
        return platformStage;
    }

    /**
     * Setter for PlatformStage
     * Checks if stage is open or closed (1 or 0)
     *
     * @param stage is the state of the truck door
     */
    @Override
    public void setPlatStage(int stage) {
        if (getCurrentSpeed() == 0) {
            if (stage == 0 || stage == 1) {
                platformStage = stage;
            } else {
                throw new RuntimeException("This platforms has 2 stages, 0 and 1!");
            }
        } else {
            throw new RuntimeException("Generics.Vehicle must be still too change platform stage!");
        }
    }

    @Override
    public void gas(double amount) {
        if (getPlatStage() != 0) {
            throw new RuntimeException("This vehicle cannot move if its platform is at more than 0 degrees!");
        } else {
            motorized.gas(amount);
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
    public void incrementSpeed(double amount) {
        motorized.incrementSpeed(amount);
    }

    @Override
    public void decrementSpeed(double amount) {
        motorized.decrementSpeed(amount);
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
    public void brake(double amount) {
        motorized.brake(amount);
    }
}
