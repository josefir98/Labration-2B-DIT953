package controller;

import model.interfaces.IVehicle;
import view.CarView;
import model.Motorized;
import model.Vehicle;
import model.gameobjects.Saab95;
import model.gameobjects.Scania;
import model.gameobjects.Volvo240;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {
    // member fields:

    // The delay (ms) corresponds to 20 updates a sec (hz)
    private final int delay = 50;
    // The timer is started with an listener (see below) that executes the statements
    // each step between delays.
    private Timer timer = new Timer(delay, new TimerListener());

    // The frame that represents this instance View of the MVC pattern
    CarView frame;
    // A list of cars, modify if needed
    ArrayList<IVehicle> cars = new ArrayList<>();

    //methods:

    public static void main(String[] args) {
        // Instance of this class
        CarController cc = new CarController();

        cc.cars.add(new Volvo240(Color.WHITE));
        cc.cars.add(new Saab95(Color.BLACK));
        cc.cars.add(new Scania(Color.RED));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0", cc);

        for (int i = 0; i < cc.cars.size(); i++) {
            cc.cars.get(i).setY(i * 100);
            cc.frame.drawPanel.init(cc.cars.get(i).getModelName());
        }

        // Start the timer
        cc.timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (IVehicle car : cars) {
                wallCol(car);
                car.move();
                String name = car.getModelName();
                int x = (int) Math.round(car.getX());
                int y = (int) Math.round(car.getY());
                frame.drawPanel.moveit(name, x, y);
                // repaint() calls the paintComponent method of the panel
                frame.drawPanel.repaint();
            }
        }
    }

    // If edge collision is detected, reverses direction.
    private void wallCol(IVehicle car) {
        int x = (int) Math.round(car.getX());
        int y = (int) Math.round(car.getY());
        if (x < 0 || x > 800 || y < 0 || y > 560) {
            car.turnLeft();
            car.turnLeft();
        }
    }

    // Calls the gas method for each car once
    public void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (IVehicle car : cars) {
            car.gas(gas);
        }
    }

    // Calls the brake method for each car once
    public void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (IVehicle car : cars) {
            car.brake(brake);
        }
    }

    public void turboOn() {
        for (IVehicle car : cars) {
            if (car.getModelName() == "Saab95") {
                Saab95 saab = (Saab95) car;
                saab.setTurboOn();
            }
        }
    }
    public void turboOff() {
        for (IVehicle car : cars) {
            if (car.getModelName() == "Saab95") {
                Saab95 saab = (Saab95) car;
                saab.setTurboOff();
            }
        }
    }

    public void liftBed() {
        for (IVehicle car : cars) {
            if (car.getModelName() == "Scania") {
                Scania scania = (Scania) car;
                scania.setPlatStage(70);
            }
        }
    }

    public void lowerBed() {
        for (IVehicle car : cars) {
            if (car.getModelName() == "Scania") {
                Scania scania = (Scania) car;
                scania.setPlatStage(0);
            }
        }
    }

    public void startEngine() {
        for (IVehicle car : cars) {
            Motorized cur = (Motorized) car;
            cur.startEngine();
        }
    }

    public void stopEngine() {
        for (IVehicle car : cars) {
            Motorized cur = (Motorized) car;
            cur.stopEngine();
        }
    }
}
