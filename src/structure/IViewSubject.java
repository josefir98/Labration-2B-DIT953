package structure;

import java.util.ArrayList;

public interface IViewSubject {
    void addObserver(IViewObserver newObserver);
    void notifyObservers(ArrayList<String> models, ArrayList<Double> xs, ArrayList<Double> ys);
}