package model;

import model.gameobjects.Saab95;
import model.gameobjects.Scania;
import model.gameobjects.Volvo240;
import model.interfaces.IVehicle;

import java.awt.*;
import java.util.Random;

public class VehicleFactory {
    public static IVehicle createVolvo240(double x, double y) {
        IVehicle volvo240 = new Volvo240(Color.BLACK);
        volvo240.setX(x);
        volvo240.setY(y);
        return volvo240;
    }

    public static IVehicle createSaab95(double x, double y) {
        IVehicle saab95 = new Saab95(Color.BLACK);
        saab95.setX(x);
        saab95.setY(y);
        return saab95;
    }

    public static IVehicle createScania(double x, double y) {
        IVehicle scania = new Scania(Color.BLACK);
        scania.setX(x);
        scania.setY(y);
        return scania;
    }

    // Snabb lösning som bryter mot OCP
    public static IVehicle createRandom(double x, double y) {
        Random rand = new Random();
        int r = rand.nextInt(3);
        IVehicle vehicle;
        if (r == 0) {
            vehicle = createVolvo240(x, y);
        } else if (r == 1) {
            vehicle = createSaab95(x, y);
        } else {
            vehicle = createScania(x, y);
        }
        return vehicle;
    }
}