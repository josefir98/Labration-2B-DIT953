package model.interfaces;

import java.awt.*;

public interface IVehicle extends IMovable {
    /**
     * enum for direction of car
     */
    enum Dir {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }

    enum Size {
        SMALL,
        MEDIUM,
        LARGE
    }

    int getNrDoors();

    double speedFactor();

    void incrementSpeed(double amount, double speedFactor);

    void decrementSpeed(double amount, double speedFactor);

    String getModelName();

    double getCurrentSpeed();

    void setCurrentSpeed(double currentSpeed);

    Color getColor();

    void setColor(Color clr);

    double getX();

    void setX(double x);

    double getY();

    void setY(double y);

    Dir getCurDir();

    void setCurDir(Dir curDir);

    void gas(double amount, double speedFactor);

    void brake(double amount, double speedFactor);
}
