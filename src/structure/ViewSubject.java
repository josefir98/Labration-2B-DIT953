package structure;

import java.util.ArrayList;

public class ViewSubject implements IViewSubject{
    ArrayList<IViewObserver> observers;

    @Override
    public void addObserver(IViewObserver newObserver) {
        observers.add(newObserver);
    }

    @Override
    public void notifyObservers(ArrayList<String> models, ArrayList<Double> xs, ArrayList<Double> ys) {
        observers.forEach(observer -> observer.update(models, xs, ys));
    }
}
