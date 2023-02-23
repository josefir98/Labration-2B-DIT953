package model.gameobjects;

import model.DualPlatform;
import model.DualPlatformDown;
import model.GraduatedPlatform;
import model.Motorized;
import model.interfaces.IGraduatedPlatform;
import model.interfaces.IMotorized;
import model.interfaces.IPlatform;
import model.interfaces.IVehicle;

import java.awt.*;

public class Scania implements IMotorized, IGraduatedPlatform {

    private final static double trimFactor = 1;

    private IGraduatedPlatform platform;

    private Motorized motorized;

    /**
     * Superclass for Scania
     *
     * @param color is the color of scania
     */
    public Scania(Color color) {
        motorized = new Motorized("Scania", color, 2, IVehicle.Size.MEDIUM, 90);
        platform = new GraduatedPlatform(new DualPlatformDown(platform));
    }

    @Override
    public int getAngle() {
        return platform.getAngle();
    }

    @Override
    public void setAngle(int newAngle) {
        if (getCurrentSpeed() == 0) {
            platform.setAngle(newAngle);
        } else {
            throw new RuntimeException("Vehicle must be still to change platform stage!");
        }
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

    /**
     * How fast the truck can accelerate
     */
    @Override
    public double speedFactor() {
        return getEnginePower() * 0.01 * trimFactor;
    }

    /**
     * Checks if door is open
     * Unable to gas if door is open (!= 0)
     *
     * @param amount
     */
    @Override
    public void gas(double amount, double speedFactor) {
        if (getPlatformState() instanceof DualPlatformDown) { //TODO getPlatformState().getClass() == DualPlatformDown.class better?
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