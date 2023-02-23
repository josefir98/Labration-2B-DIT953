package model.gameobjects;

import model.DualPlatform;
import model.PlatformDown;
import model.Motorized;
import model.interfaces.IMotorized;
import model.interfaces.IPlatform;
import model.Storage;

import java.awt.*;

public class CarCarrierScania implements IMotorized, IPlatform {
    private final static double trimFactor = 1.1;
    private final Storage<IMotorized, CarCarrierScania> carsStored = new Storage();
    private IPlatform platform;

    private final Motorized motorized;

    /**
     * Superclass for CarCarrierScania
     *
     * @param color is the color of the car carier
     */
    public CarCarrierScania(Color color) {
        motorized = new Motorized("CarCarrierScania", color, 2, Size.LARGE, 95);
        platform = new DualPlatform(new PlatformDown(platform));
    }

    @Override
    public void lower() {
        platform.lower();
    }

    @Override
    public void lift() {
        if (getCurrentSpeed() == 0) {
            platform.lift();
        } else {
            throw new RuntimeException("Vehicle must be still to change platform stage!");
        }
    }

    @Override
    public void setPlatformState(IPlatform state) {
        platform.setPlatformState(state);
    }

    @Override
    public IPlatform getPlatformState() {
        return platform.getPlatformState();
    }

    @Override
    public boolean isDown() {
        return platform.isDown();
    }

    /**
     * How fast the truck can accelerate
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

    @Override
    public void gas(double amount, double speedFactor) {
        if (isDown()) {
            motorized.gas(amount, speedFactor);
        } else {
            throw new RuntimeException("This vehicle cannot move if its platform is up");
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
    public Dir getCurDir() {
        return motorized.getCurDir();
    }

    @Override
    public void setCurDir(Dir curDir) {
        motorized.setCurDir(curDir);
    }

    @Override
    public void brake(double amount, double speedFactor) {
        motorized.brake(amount, speedFactor);
    }
}
