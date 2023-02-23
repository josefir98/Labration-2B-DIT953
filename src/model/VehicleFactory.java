package model;

import model.gameobjects.Saab95;
import model.gameobjects.Scania;
import model.gameobjects.Volvo240;
import model.interfaces.IVehicle;

import java.awt.*;
import java.util.Random;

public class VehicleFactory {
    public static Volvo240 createVolvo240(double x, double y) {
        Volvo240 volvo240 = new Volvo240(Color.BLACK);
        volvo240.setX(x);
        volvo240.setY(y);
        return volvo240;
    }

    public static Saab95 createSaab95(double x, double y) {
        Saab95 saab95 = new Saab95(Color.BLACK);
        saab95.setX(x);
        saab95.setY(y);
        return saab95;
    }

    public static Scania createScania(double x, double y) {
        Scania scania = new Scania(Color.BLACK);
        scania.setX(x);
        scania.setY(y);
        return scania;
    }

    public static IVehicle createRandom(double x, double y) {
        Random rand = new Random();
        int r = rand.nextInt(3);
        IVehicle vehicle;
        if (r == 0) {
            vehicle = new Volvo240(Color.BLACK);
        } else if (r == 1) {
            vehicle = new Saab95(Color.BLACK);
        } else {
            vehicle = new Scania(Color.BLACK);
        }

        vehicle.setX(x);
        vehicle.setY(y);
        return vehicle;
    }
}