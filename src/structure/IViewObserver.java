package structure;

import java.util.ArrayList;

public interface IViewObserver {
    void update(ArrayList<String> models, ArrayList<Double> xs, ArrayList<Double> ys);
}
