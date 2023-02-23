package model.gameobjects;

import model.interfaces.IMotorized;

import java.util.ArrayList;

public class CarGarage<T extends IMotorized> {
    private final int maxCars;
    private ArrayList<T> cars = new ArrayList<T>();

    public CarGarage(int maxCars) {
        this.maxCars = maxCars;
    }

    /**
     * Removes car from garage
     * @param car is any car
     * @return
     */
    public T remove(T car) {
        cars.remove(car);
        return car;
    }

    /**
     * Adds car to garage if garage is not full
     * @param car is any car
     */
    public void add(T car) {
        if (cars.size() <= maxCars) {
            cars.add(car);
        }else{
            throw new RuntimeException("The Garage is full!");
        }
    }
}
