package structure.observer;

import model.interfaces.IVehicle;

import java.util.ArrayList;

public interface IViewObserver {
    void update(ArrayList<IVehicle> cars);
}
