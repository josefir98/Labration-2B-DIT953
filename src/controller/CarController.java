package controller;

import model.World;
import model.Wrapper;
import view.CarView;
import view.DrawPanel;

import javax.swing.*;
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
    World world;

    //methods:

    public CarController(World world) {
        this.world = world;


        // Start the timer
        timer.start(); // TODO Flytta till world
    }

    /* Each step the TimerListener moves all the cars in the list and tells the
     * view to update its images. Change this method to your needs.
     * */
    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            world.wallCol();
            world.move();
            // repaint() calls the paintComponent method of the panel
            world.notifyObservers();
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
