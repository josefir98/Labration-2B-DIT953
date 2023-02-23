package controller;

import model.World;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:
    World world;

    //methods:

    public CarController(World world) {
        this.world = world;
    }

    public void addCar() {
        world.addCar();
    }
    public void removeCar() {
        world.removeCar();
    }
    // Calls the gas method for each car once
    public void gas(int amount) {
        world.gas(amount);
    }

    // Calls the brake method for each car once
    public void brake(int amount) {
        world.brake(amount);
    }

    public void turboOn() {
        world.turboOn();
    }
    public void turboOff() {
        world.turboOff();
    }

    public void liftBed() {
        world.liftBed();
    }

    public void lowerBed() {
        world.lowerBed();
    }

    public void startEngine() {
        world.startEngine();
    }

    public void stopEngine() {
        world.stopEngine();
    }
}
