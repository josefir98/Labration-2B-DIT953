package structure;

import model.interfaces.IVehicle;

import java.util.ArrayList;

public class ViewSubject implements IViewSubject{
    ArrayList<IViewObserver> observers;

    @Override
    public void addObserver(IViewObserver newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void notifyObservers(ArrayList<IVehicle> cars) {
        observers.forEach(observer -> observer.update(cars));
    }
}
