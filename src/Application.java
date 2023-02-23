import controller.CarController;
import model.VehicleFactory;
import model.World;
import model.gameobjects.Saab95;
import model.gameobjects.Scania;
import model.gameobjects.Volvo240;
import model.interfaces.IMotorized;
import model.interfaces.IVehicle;
import view.CarView;

import java.awt.*;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        IVehicle volvo = VehicleFactory.createVolvo240(0, 0);
        IVehicle saab = VehicleFactory.createSaab95(0, 0);
        IVehicle scania = VehicleFactory.createScania(0, 0);

        ArrayList<IVehicle> cars = new ArrayList<>();

        cars.add(volvo);
        cars.add(saab);
        cars.add(scania);

        World world = new World(cars);
        world.addComponent(volvo);
        world.addComponent(saab);
        world.addComponent(scania);

        CarController cc = new CarController(world);
        // The frame that represents this instance View of the MVC pattern
        CarView frame = new CarView("CarSim 1.0", cc);

        world.addObserver(frame.drawPanel);
    }
}
