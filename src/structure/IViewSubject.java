package structure;

import model.interfaces.IVehicle;

import java.util.ArrayList;

public interface IViewSubject {
    void addObserver(IViewObserver newObserver);
    void notifyObservers(ArrayList<IVehicle> cars);
}