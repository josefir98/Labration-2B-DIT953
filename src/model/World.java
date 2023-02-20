package model;

import model.gameobjects.Saab95;
import model.gameobjects.Scania;
import model.interfaces.IMotorized;

import java.util.ArrayList;

public class World {
    ArrayList<IMotorized> cars;
    ArrayList<Wrapper> wCars;

    public World(ArrayList<IMotorized> cars) {
        wCars = new ArrayList<>();

        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).setY(i * 100);
            String name = cars.get(i).getModelName();
            double x = cars.get(i).getX();
            double y = cars.get(i).getY();
            wCars.add(new Wrapper(name, x, y));
        }
    }

    public ArrayList<Wrapper> getCars() {
        return wCars;
    }

    // If edge collision is detected, reverses direction.
    public void wallCol() {
        for (IMotorized car : cars) {
            int x = (int) Math.round(car.getX());
            int y = (int) Math.round(car.getY());
            if (x < 0 || x > 800 || y < 0 || y > 560) {
                car.turnLeft();
                car.turnLeft();
            }
        }
    }

    public void move() {
        for (IMotorized car : cars) {
            car.move();
        }
    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (IMotorized car : cars) {
            car.gas(gas, car.speedFactor());
        }
    }

    // Calls the brake method for each car once
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (IMotorized car : cars) {
            car.brake(brake, car.speedFactor());
        }
    }

    public void turboOn() {
        for (IMotorized car : cars) {
            if (car.getModelName() == "Saab95") {
                Saab95 saab = (Saab95) car;
                saab.setTurboOn();
            }
        }
    }
    public void turboOff() {
        for (IMotorized car : cars) {
            if (car.getModelName() == "Saab95") {
                Saab95 saab = (Saab95) car;
                saab.setTurboOff();
            }
        }
    }

    public void liftBed() {
        for (IMotorized car : cars) {
            if (car.getModelName() == "Scania") {
                Scania scania = (Scania) car;
                scania.setPlatStage(70);
            }
        }
    }

    public void lowerBed() {
        for (IMotorized car : cars) {
            if (car.getModelName() == "Scania") {
                Scania scania = (Scania) car;
                scania.setPlatStage(0);
            }
        }
    }

    public void startEngine() {
        for (IMotorized car : cars) {
            car.startEngine();
        }
    }

    public void stopEngine() {
        for (IMotorized car : cars) {
            car.stopEngine();
        }
    }
}
