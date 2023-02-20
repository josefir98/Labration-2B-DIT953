package model;

import model.interfaces.IMovable;
import model.interfaces.IVehicle;

import java.awt.*;

public class Vehicle implements IVehicle {

    private String modelName; // The car model name
    private Color color; // Color of the car
    private double currentSpeed; // The current speed of the car
    private double x;
    private double y;
    private Dir curDir;
    int nrDoors;
    Size size;

    /**
     * Constructor for Vehicle
     *
     * @param modelName is the type of car
     * @param color     color is the color
     */
    public Vehicle(String modelName, Color color, int nrDoors, Size size) {
        this.modelName = modelName;
        this.color = color;
        this.nrDoors = nrDoors;
        this.size = size;
        this.curDir = Dir.RIGHT;
    }

    @Override
    public int getNrDoors() {
        return nrDoors;
    }

    /**
     * How fast the car can accelerate
     *
     * @return
     */
    @Override
    public double speedFactor() {
        return 1;
    }

    @Override
    public void incrementSpeed(double amount, double speedFactor) {
        double speed = getCurrentSpeed() + speedFactor * amount;
        if (speed > getCurrentSpeed()) {
            setCurrentSpeed(speed);
        }
    }

    @Override
    public void decrementSpeed(double amount, double speedFactor) {
        double speed = Math.max(getCurrentSpeed() - speedFactor * amount, 0);
        if (speed < getCurrentSpeed()) {
            setCurrentSpeed(speed);
        }
    }

    /**
     * Getter for model name of vehicle
     *
     * @return
     */
    @Override
    public String getModelName() {
        return modelName;
    }

    /**
     * Getter for current speed of car
     *
     * @return
     */
    @Override
    public double getCurrentSpeed() {
        return currentSpeed;
    }

    /**
     * Takes current speed and sees that it does not overstep enginePower
     *
     * @param currentSpeed
     */
    @Override
    public void setCurrentSpeed(double currentSpeed) {
        this.currentSpeed = currentSpeed;
    }

    /**
     * Getter for color of Vehicle
     *
     * @return
     */
    @Override
    public Color getColor() {
        return color;
    }

    /**
     * Setter for color of car
     *
     * @param clr
     */
    @Override
    public void setColor(Color clr) {
        color = clr;
    }

    /**
     * Getter for x pos of vehicle
     *
     * @return
     */
    @Override
    public double getX() {
        return x;
    }

    /**
     * Setter for x pos of vehicle
     *
     * @return
     */
    @Override
    public void setX(double x) {
        this.x = x;
    }

    /**
     * Getter for y pos of vehicle
     *
     * @return
     */
    @Override
    public double getY() {
        return y;
    }

    /**
     * Setter for y pos of vehicle
     *
     * @return
     */
    @Override
    public void setY(double y) {
        this.y = y;
    }

    /**
     * Getter for current direction of car
     *
     * @return
     */
    @Override
    public Dir getCurDir() {
        return curDir;
    }

    /**
     * Setter for current direction of car
     *
     * @return
     */
    @Override
    public void setCurDir(Dir curDir) {
        this.curDir = curDir;
    }

    /**
     * Increases the speed of the car and checks if amount is outside the parameter 0 to 1
     *
     * @param amount
     */
    @Override
    public void gas(double amount, double speedFactor) {
        if (amount <= 1 && amount >= 0) {
            incrementSpeed(amount, speedFactor);
        } else {
            throw new IllegalArgumentException("Parameter must be in intervall[0,1]");
        }
    }

    /**
     * Breaks the car and checks if amount is outside the parameter 0 to 1
     *
     * @param amount
     */
    @Override
    public void brake(double amount, double speedFactor) {
        if (amount <= 1 && amount >= 0) {
            decrementSpeed(amount, speedFactor);
        } else {
            throw new IllegalArgumentException("Parameter must be in intervall[0,1]");
        }
    }

    /**
     * Moving position of the car on the x and y axis
     */
    @Override
    public void move() {
        if (curDir == Dir.RIGHT) {
            x += currentSpeed;
        } else if (curDir == Dir.LEFT) {
            x -= currentSpeed;
        } else if (curDir == Dir.UP) {
            y += currentSpeed;
        } else if (curDir == Dir.DOWN) {
            y -= currentSpeed;
        }
    }

    /**
     * Turning car left depending of current orientation
     */
    @Override
    public void turnLeft() {
        if (curDir == Dir.RIGHT) {
            curDir = Dir.UP;
        } else if (curDir == Dir.LEFT) {
            curDir = Dir.DOWN;
        } else if (curDir == Dir.UP) {
            curDir = Dir.LEFT;
        } else if (curDir == Dir.DOWN) {
            curDir = Dir.RIGHT;
        }
    }

    /**
     * Turning car right depending of current orientation
     */
    @Override
    public void turnRight() {
        if (curDir == Dir.RIGHT) {
            curDir = Dir.DOWN;
        } else if (curDir == Dir.LEFT) {
            curDir = Dir.UP;
        } else if (curDir == Dir.UP) {
            curDir = Dir.RIGHT;
        } else if (curDir == Dir.DOWN) {
            curDir = Dir.LEFT;
        }
    }
}
