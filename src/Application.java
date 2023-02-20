import controller.CarController;
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

        cars.add(new Volvo240(Color.WHITE));
        cars.add(new Saab95(Color.BLACK));
        cars.add(new Scania(Color.RED));

        World world = new World(cars);

        CarController cc = new CarController(world);
    }
}
