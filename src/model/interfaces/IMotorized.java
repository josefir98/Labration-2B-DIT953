package model.interfaces;

public interface IMotorized extends IVehicle {
    double getEnginePower();

    void startEngine();

    void stopEngine();
}