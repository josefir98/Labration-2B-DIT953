package model;

import controller.CarController;
import model.gameobjects.Saab95;
import model.gameobjects.Scania;
import model.interfaces.IGraduatedPlatform;
import model.interfaces.IMotorized;
import model.interfaces.IVehicle;
import structure.IViewObserver;
import structure.IViewSubject;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class World implements IViewSubject {
    ArrayList<IViewObserver> observers;
    ArrayList<IVehicle> cars;

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new World.TimerListener());

    public World(ArrayList<IVehicle> cars) {
        this.cars = cars;
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).setY(i * 100);
        }
        observers = new ArrayList<>();

        // Start the timer
        timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            wallCol();
            move();
            notifyObservers(cars);
        }
    }

    @Override
    public void addObserver(IViewObserver newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void notifyObservers(ArrayList<IVehicle> cars) {
        observers.forEach(observer -> observer.update(cars));
    }

    public ArrayList<IVehicle> getCars() {
        return cars;
    }

    // If edge collision is detected, reverses direction.
    public void wallCol() {
        for (IVehicle car : cars) {
            int x = (int) Math.round(car.getX());
            int y = (int) Math.round(car.getY());
            if (x < 0 || x > 800 || y < 0 || y > 560) {
                car.turnLeft();
                car.turnLeft();
            }
        }
    }

    public void move() {
        for (IVehicle car : cars) {
            car.move();
        }
    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (IVehicle car : cars) {
            car.gas(gas, car.speedFactor());
        }
    }

    // Calls the brake method for each car once
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (IVehicle car : cars) {
            car.brake(brake, car.speedFactor());
        }
    }

    public void turboOn() {
        for (IVehicle car : cars) {
            if (car.getModelName().equals("Saab95")) {
                Saab95 saab = (Saab95) car;
                saab.setTurboOn();
            }
        }
    }
    public void turboOff() {
        for (IVehicle car : cars) {
            if (car.getModelName().equals("Saab95")) {
                Saab95 saab = (Saab95) car;
                saab.setTurboOff();
            }
        }
    }

    public void liftBed() {
        for (IVehicle car : cars) {
            if (car.getModelName().equals("Scania")) {
                IGraduatedPlatform scania = (IGraduatedPlatform) car;
                scania.setAngle(70);
            }
        }
    }

    public void lowerBed() {
        for (IVehicle car : cars) {
            if (car.getModelName().equals("Scania")) {
                IGraduatedPlatform scania = (IGraduatedPlatform) car;
                scania.setAngle(0);
            }
        }
    }

    public void startEngine() {
        for (IVehicle car : cars) {
            IMotorized cur = (IMotorized) car;
            cur.startEngine();
        }
    }

    public void stopEngine() {
        for (IVehicle car : cars) {
            IMotorized cur = (IMotorized) car;
            cur.stopEngine();
        }
    }
}
