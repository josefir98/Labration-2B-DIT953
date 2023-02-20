package controller;

import model.World;
import model.Wrapper;
import model.interfaces.IMotorized;
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
    ArrayList<Wrapper> wCars;

    World world;

    //methods:

    public CarController(World world) {
        this.world = world;
        this.wCars = this.world.getCars();

        // Start a new view and send a reference of self
        frame = new CarView("CarSim 1.0", this);

        for (int i = 0; i < wCars.size(); i++) {
            frame.drawPanel.init(wCars.get(i).getModelName());
        }

        // Start the timer
        timer.start();
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            world.wallCol();
            world.move();
            String name = car.getModelName();
            int x = (int) Math.round(car.getX());
            int y = (int) Math.round(car.getY());
            frame.drawPanel.moveit(name, x, y);
            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.repaint();
        }
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
