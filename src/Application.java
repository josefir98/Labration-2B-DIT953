import controller.CarController;
import model.VehicleFactory;
import model.World;
import model.gameobjects.Saab95;
import model.gameobjects.Scania;
import model.gameobjects.Volvo240;
import model.interfaces.IMotorized;

import java.awt.*;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        ArrayList<IMotorized> cars = new ArrayList<>();

        cars.add(VehicleFactory.createVolvo240(0, 0));
        cars.add(VehicleFactory.createSaab95(0, 0));
        cars.add(VehicleFactory.createScania(0, 0));

        World world = new World(cars);

        new CarController(world);
    }
}
